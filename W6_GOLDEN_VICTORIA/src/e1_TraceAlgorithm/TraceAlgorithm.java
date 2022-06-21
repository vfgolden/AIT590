package e1_TraceAlgorithm;

import java.awt.RenderingHints.Key;

@SuppressWarnings("hiding")
public class TraceAlgorithm<Key, Value> {
	private Node first = null; // first node in the linked list

	private class Node { // linked-list node
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			System.out.print(key + ", " + val);
			this.next = next;
		}
	}

	public Value get(Key key) { // Search for key, return associated value.
		System.out.print("Node first = {");
		printNode(first, new StringBuilder("}"));
		System.out.println("get(" + key + ")key=" + key);
		for (Node x = first; x != null; x = x.next) {
			if (x == first)
				System.out.print("x = {");
			else
				System.out.print("x = x.next = {");
			printNode(x, new StringBuilder("}"));
			if (key.equals(x.key)) {
				System.out.println("x.key = " + x.key + " equal with " + key);
				System.out.println("return x.val = \"" + x.val + "\"");
				return x.val; // search hit
			}
			System.out.println("x.key = " + x.key + " not equal with " + key);
			if (x.next != null)
				System.out.println("x not null. continue the for loop");
		}
		System.out.println(key + " not found in list, returning null.");
		return null; // search miss
	}

	public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
		System.out.print("put(");
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				System.out.println("Duplicate key found.)");
				x.val = val;
				System.out.print("");
				return;
			} // Search hit: update val.
		first = new Node(key, val, first);// Search miss: add new node.
		System.out.println(")");
		System.out.print("Node first = {");
		printNode(first, new StringBuilder("}"));
	}

	public void printNode(Node node, StringBuilder brackets) {
		System.out.print("key=\"" + node.key + "\", ");
		System.out.print("val=\"" + node.val + "\", ");
		if (node.next == null) {
			System.out.println("next=null" + brackets.toString());
		} else {
			System.out.print("next={");
			brackets.append("}");
			printNode(node.next, brackets);
		}
	}

	public static void main(String[] args) {
		System.out.println("Exercise 1: Trace Algorithm 3.1 by Victoria Golden\n");

		System.out.println("Step 1 Trace");
		// Creating object of the
		// class linked list
		TraceAlgorithm<String, String> ll = new TraceAlgorithm<String, String>();
		System.out.println("Node first = null;");

		ll.put("V", "first letter");
		ll.put("I", "second letter");
		ll.put("C", "third letter");
		ll.put("T", "fourth letter");
		ll.put("O", "fifth letter");
		ll.put("R", "sixth letter");
		ll.put("I", "seventh letter");
		ll.put("A", "eigth letter");
		ll.put("G", "ninth letter");
		ll.put("N", "tenth letter");

		System.out.println("\n\nStep 2 Trace");
		ll.get("I");

		System.out.println("\n\nStep 3 Trace");
		ll.get("Z");
	}
}
