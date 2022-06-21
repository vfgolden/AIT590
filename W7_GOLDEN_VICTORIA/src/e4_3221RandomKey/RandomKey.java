package e4_3221RandomKey;

import java.util.Random;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Victoria Golden
 *
 *         3.2.21 Add a BST method randomKey() that returns a random key from
 *         the symbol table in time proportional to the tree height, in the
 *         worst case.
 * 
 *         Credit for majority of code goes to @HatlessFox
 */

public class RandomKey<Key extends Comparable<Key>> implements BST_Test.BST<Key, String> {

	private static final int CMP_TREE_KEY = 0;
	private Node root;
	private Random rnd = new Random();

	private class Node {
		Key k;
		Node left, right;

		public Node(Key key) {
			k = key;
		}
	}

	public void put(Key key, String value) {
		root = put(root, key, value);
	}

	private Node put(Node tree, Key key, String value) {
		if (tree == null) {
			return new Node(key);
		}

		int cmp_key = key.compareTo(tree.k);
		if (cmp_key < CMP_TREE_KEY) {
			tree.left = put(tree.left, key, value);
		} else if (CMP_TREE_KEY < cmp_key) {
			tree.right = put(tree.right, key, value);
		}
		return tree;
	}

	public Key randomKey() {
		return root != null ? randomKey(root) : null;
	}

	public Key randomKey(Node tree) {
		if (tree.left == null && tree.right == null) {
			return tree.k;
		}
		if (rnd.nextBoolean()) {
			return tree.k;
		}

		if (tree.left == null) {
			return randomKey(tree.right);
		}
		if (tree.right == null) {
			return randomKey(tree.left);
		}
		return randomKey(rnd.nextBoolean() ? tree.left : tree.right);
	}

	public static class Event implements Comparable<Event> {
		private Time t;

		public Event(int h, int m, int s) {
			t = new Time(h, m, s);
		}

		@Override
		public int compareTo(Event that) {
			return t.compareTo(that.t);
		}

		@Override
		public String toString() {
			return t.toString();
		}
	}

	public static class Time implements Comparable<Time> {
		private int h, m, s;

		public Time(int hrs, int mns, int scs) {
			h = hrs;
			m = mns;
			s = scs;
		}

		@Override
		public int compareTo(Time t) {
			int h_diff = h - t.h;
			if (h_diff != 0) {
				return h_diff;
			}
			int m_diff = m - t.m;
			if (m_diff != 0) {
				return m_diff;
			}
			return s - t.s;
		}

		@Override
		public String toString() {
			return String.format("%02d:%02d:%02d", h, m, s);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		System.out.println("RandomKey in BST by Victoria Golden\n");

		RandomKey<Event> bst = new RandomKey<>();
		BST_Test.addWithTestData(bst);

		StdOut.println("Printing 5 Random Keys");
		for (int i = 0; i < 5; ++i) {
			StdOut.printf("%s\n", bst.randomKey());
		}
	}
}
