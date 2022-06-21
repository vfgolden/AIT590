package e2_deque;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Victoria Golden
 *
 *         Exercise 1.3.33: Deque
 * 
 *         Book: Deque. A double-ended queue or deque (pronounced “deck”) is
 *         like a stack or a queue but supports adding and removing items at
 *         both ends. Write a class Deque that uses a doubly-linked list to
 *         implement this API and a class ResizingArrayDeque that uses a
 *         resizing array
 */

public class Deque_1333<Item> implements Iterable<Item> {

	private int N; // no of items in the list
	private Node first; // required for queue
	private Node last; // required for stack

	/**
	 * Creates an empty deque
	 * 
	 * @return
	 */
	public void Deque() {
		first = null;
		last = null;
		N = 0;
	}

	/**
	 * Boolean method to return true if deque is empty otherwise false
	 * 
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * Method to return the number of items in the deque
	 * 
	 * @return N, number of items in list
	 */
	public int size() {
		return N;
	}

	/**
	 * Method to add and item at the beginning (left) of the deque
	 * 
	 * @param value
	 */
	public void pushLeft(Item value) {
		// create a node, initialize it
		Node oldFirst = first;
		first = new Node(value);
		first.item = value;
		first.next = oldFirst;
		first.prev = null;
		// make it the first node in the list.
		if (oldFirst != null)
			oldFirst.prev = first;
		if (last == null)
			last = first;
		N++;
	}

	/**
	 * Method to add an item at the end (right) of the deque
	 * 
	 * @param value
	 */
	public void pushRight(Item value) {
		Node oldLast = last;
		last = new Node(value);
		last.item = value;
		last.next = null;
		last.prev = oldLast;
		// make it the last node in the list.
		if (oldLast != null) {
			oldLast.next = last;
		}
		if (first == null)
			first = last;
		N++;
	}

	/**
	 * Method to pop out or remove the first (leftmost) item from the queue
	 * 
	 * @return
	 */
	public Item popLeft() {
		if (first == null)
			return null;
		// the second item now becomes the first
		Item value = first.item;
		first = first.next;
		if (first != null)
			first.prev = null;
		else
			last = null;
		N--;
		return value;
	}

	/**
	 * Method to pop out or remove the last (rightmost) item from the queue
	 * 
	 * @return
	 */
	public Item popRight() {
		if (last == null)
			return null;
		// the second last item now becomes last item
		Item value = last.item;
		last = last.prev;
		if (last != null)
			last.next = null;
		else {
			first = null;
		}
		N--; // decrement element count.
		return value;
	}

	/**
	 * Iterator creator
	 */
	public Iterator iterator() {
		return new DequeIterator();
	}

	/**
	 * Helper class to point to items in the queue
	 */
	private class Node {
		Item item;
		Node next;
		Node prev;

		Node(Item item) {
			this.item = item;
			next = null;
		}
	}

	/**
	 * Nested class that implements the Iterator object
	 */
	private class DequeIterator implements Iterator {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {

		}
	}

	/**
	 * Testing method for deque
	 * 
	 * @param title
	 * @param list
	 */
	public static void testDeque(String title, Deque_1333 list) {
		StdOut.println(title);
		for (Object element : list) {
			StdOut.print(element + " ");
		}
		StdOut.println();
		StdOut.println("size of list: " + list.size());
		StdOut.println();
		list.popLeft();
		StdOut.println("Deque after popLeft:");
		for (Object element : list) {
			StdOut.print(element + " ");
		}
		StdOut.println();
		StdOut.println("size of list: " + list.size());
		StdOut.println();
		list.popRight();
		StdOut.println("Deque after popRight:");
		for (Object element : list) {
			StdOut.print(element + " ");
		}
		StdOut.println();
		StdOut.println("size of list: " + list.size());
		StdOut.println();
		list.pushLeft("value");
		StdOut.println("Deque after pushLeft:");
		for (Object element : list) {
			StdOut.print(element + " ");
		}
		StdOut.println();
		StdOut.println("size of list: " + list.size());
		StdOut.println();
		list.pushRight("value2");
		StdOut.println("Deque after pushRight:");
		for (Object element : list) {
			StdOut.print(element + " ");
		}
		StdOut.println();
		StdOut.println("size of list: " + list.size());
		StdOut.println();
	}

	public static void main(String[] args) {
		System.out.println("Deque by Victoria Golden\n");

		Deque_1333 deque = new Deque_1333();
		String[] test = { "dogs", "cats", "video games", "cow", "chair", "thermostat" };
		for (int i = 0; i < test.length; i++) {
			deque.pushLeft(test[i]);
		}

		testDeque("Deque test list: ", deque);
	}
}
