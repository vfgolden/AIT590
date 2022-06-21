package e2_3213NonRecursiveBST;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Victoria Golden
 *
 *         3.2.13 Give nonrecursive implementations of get() and put() for BST.
 *         The implementation of put() is more complicated because of the need
 *         to save a pointer to the parent node to link in the new node at the
 *         bottom. Also, you need a separate pass to check whether the key is
 *         already in the table because of the need to update the counts. Since
 *         there are many more searches than inserts in performance-critical
 *         implementations, using this code for get() is justified; the
 *         corresponding change for put() might not be noticed.
 */

public class BST<Key extends Comparable<Key>, Value> {

	// root of BST
	private Node root;

	private class Node {
		private Key key; // sorted by key
		private Value val; // associated value
		private Node left, right; // left and right subtrees

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}

	/**
	 * Nonrecursive version of put() for BST
	 * 
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		Node z = new Node(key, val);
		if (root == null) {
			root = z;
			return;
		}

		Node parent = null, x = root;
		while (x != null) {
			parent = x;
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else {
				x.val = val;
				return;
			}
		}
		int cmp = key.compareTo(parent.key);
		if (cmp < 0)
			parent.left = z;
		else
			parent.right = z;
	}

	/**
	 * Nonrecursive version of get() for BST
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x.val;
		}
		return null;
	}

	/***************************************************************************
	 * Inorder traversal.
	 ***************************************************************************/

	/**
	 * Books implementation of an in order search method
	 * 
	 * @return
	 */
	public Iterable<Key> keys() {
		Stack<Node> stack = new Stack<Node>();
		Queue<Key> queue = new Queue<Key>();
		Node x = root;
		while (x != null || !stack.isEmpty()) {
			if (x != null) {
				stack.push(x);
				x = x.left;
			} else {
				x = stack.pop();
				queue.enqueue(x.key);
				x = x.right;
			}
		}
		return queue;
	}

	/**
	 * Main method for test cases
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Nonrecursive put() and get() for BST by Victoria Golden\n");
		
		System.out.println("Enter a series of letters: "); 
		String[] a = StdIn.readAllStrings();
		int n = a.length;
		BST<String, Integer> st = new BST<String, Integer>();
		for (int i = 0; i < n; i++)
			st.put(a[i], i);
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}

}
