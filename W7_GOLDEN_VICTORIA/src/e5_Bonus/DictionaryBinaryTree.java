package e5_Bonus;

import edu.princeton.cs.algs4.StdOut;

public class DictionaryBinaryTree implements Dictionary {

	/**
	 * size is the number of items stored in the dictionary. root is the
	 * BinaryTreeNode that serves as root of the tree. If there are no items, size
	 * is zero and root is null.
	 **/
	protected int size;
	protected BinaryTreeNode root;

	/**
	 * Construct an empty binary tree.
	 **/
	public DictionaryBinaryTree() {
		makeEmpty();
	}

	/**
	 * makeEmpty() removes all the entries from the dictionary.
	 */
	public void makeEmpty() {
		size = 0;
		root = null;
	}

	/**
	 * size() returns the number of entries stored in the dictionary.
	 *
	 * @return the number of entries stored in the dictionary.
	 **/
	public int size() {
		return size;
	}

	/**
	 * isEmpty() tests if the dictionary is empty.
	 *
	 * @return true if the dictionary has no entries; false otherwise.
	 **/
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * insert() constructs and inserts a new Entry object, consisting of a (key,
	 * value) pair, into the dictionary, and returns a reference to the new Entry.
	 * Multiple entries with the same key (or even the same key and value) can
	 * coexist in the dictionary.
	 *
	 * @param key   the key by which the entry can be retrieved. Must be of a class
	 *              that implements java.lang.Comparable.
	 * @param value an arbitrary object associated with the key.
	 * @return an Entry object referencing the key and value.
	 **/
	@SuppressWarnings("rawtypes")
	public Entry insert(Object key, Object value) {
		Entry entry = new Entry(key, value);
		if (root == null) {
			root = new BinaryTreeNode(entry);
		} else {
			insertHelper(entry, (Comparable) key, root);
		}

		size++;
		return entry;
	}

	/**
	 * insertHelper() recursively does the work of inserting a new Entry object into
	 * the dictionary.
	 *
	 * @param entry the Entry object to insert into the tree.
	 * @param key   the key by which the entry can be retrieved.
	 * @param node  the root of a subtree in which the new entry will be inserted.
	 **/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void insertHelper(Entry entry, Comparable key, BinaryTreeNode node) {
		if (key.compareTo(node.entry.key()) <= 0) {
			if (node.leftChild == null) {
				node.leftChild = new BinaryTreeNode(entry, node);
			} else {
				insertHelper(entry, key, node.leftChild);
			}
		} else {
			if (node.rightChild == null) {
				node.rightChild = new BinaryTreeNode(entry, node);
			} else {
				insertHelper(entry, key, node.rightChild);
			}
		}
	}

	/**
	 * find() searches for an entry with the specified key. If such an entry is
	 * found, it returns the Entry object; otherwise, it returns null. If more than
	 * one entry has the key, one of them is chosen arbitrarily and returned.
	 *
	 * @param key the search key. Must be of a class that implements
	 *            java.lang.Comparable.
	 * @return an Entry referencing the key and an associated value, or null if no
	 *         entry contains the specified key.
	 **/
	@SuppressWarnings("rawtypes")
	public Entry find(Object key) {
		BinaryTreeNode node = findHelper((Comparable) key, root);
		if (node == null) {
			return null;
		} else {
			return node.entry;
		}
	}

	/**
	 * Search for a node with the specified key, starting from "node". If a matching
	 * key is found (meaning that key1.compareTo(key2) == 0), return a node
	 * containing that key. Otherwise, return null.
	 *
	 * Be sure this method returns null if node == null.
	 **/

	@SuppressWarnings("rawtypes")
	private BinaryTreeNode findHelper(Comparable key, BinaryTreeNode node) {
		// Replace the following line with your solution.
		return null;
	}

	/**
	 * remove() searches for an entry with the specified key. If such an entry is
	 * found, it removes the Entry object from the Dictionary and returns it;
	 * otherwise, it returns null. If more than one entry has the key, one of them
	 * is chosen arbitrarily, removed, and returned.
	 *
	 * @param key the search key. Must be of a class that implements
	 *            java.lang.Comparable.
	 * @return an Entry referencing the key and an associated value, or null if no
	 *         entry contains the specified key.
	 **/
	public Entry remove(Object key) {
		// Replace the following line with your solution.
		return null;
	}

	/**
	 * Convert the tree into a string.
	 **/

	public String toString() {
		if (root == null) {
			return "";
		} else {
			return root.toString();
		}
	}

	/**
	 * Bonus Step #2
	 * 
	 * @return
	 */
	public static DictionaryBinaryTree initialize() {
		DictionaryBinaryTree tree = new DictionaryBinaryTree();

		System.out.println("Inserting terms from textbook.");
		tree.insert("variable", "names a data-type value");
		tree.insert("operator", "names a data-type operation");
		tree.insert("literal", "source-code representation\r\n" + "of a value");
		tree.insert("expression", "a literal, a variable, or a\r\n" + "sequence of operations on\r\n"
				+ "literals and/or variables that\r\n" + "produces a value");
		tree.insert("declaration", "create a variable of a specified type,\r\n" + "named with a given identifier");
		tree.insert("assignment", "assign a data-type value to a variable");
		tree.insert("call", "invoke other methods");
		tree.insert("return", "return from a method");
		tree.insert("max", "largest value");
		tree.insert("min", "smallest value");
		tree.insert("mean", "average");
		tree.insert("var", "sample variance");
		tree.insert("stddev", "sample standard deviation");
		tree.insert("linked list", "recursive data structure that is either empty or a reference");
		tree.insert("floor", "largest integer not greater than x");

		System.out.println("Tree Size:  " + tree.size());
		return tree;
	}

	public void print(DictionaryBinaryTree tree) {
		// 
		System.out.print(root);
	}

	/* Tests the binary search tree. */
	public static void main(String[] args) {
		StdOut.println("Bonus Exercise by Victoria Golden\n");
		DictionaryBinaryTree tree = new DictionaryBinaryTree();

		StdOut.println("Current size of binary tree: " + tree.size());
		tree = initialize();

	}
}
