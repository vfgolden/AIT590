package e1_steque;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Victoria Golden This class creates a steque that supports push, pop,
 *         and enqueue
 * 
 *         Book description: Steque. A stack-ended queue or steque is a data
 *         type that supports push, pop, and enqueue. Articulate an API for this
 *         ADT. Develop a linked-list-based implementation
 */

public class Steque_1332<Item> implements Iterable<Item> {

	private class Node {
		Item item;
		Node next;

		Node(Item item) {
			this.item = item;
			next = null;
		}
	}

	private Node first; // required for queue
	private Node last; // required for stack
	private int N; // no of items in the list

	public void steque() {
		first = null;
		last = null;
		N = 0;
	}

	// return true if linked list is empty
	public boolean isEmpty() {
		return N == 0;
	}

	// return size of linked list
	public int size() {
		return N;
	}

	/**
	 * push the given item at the beginning of steque
	 * 
	 * @param value
	 */
	public void push(Item value) {
		if (isEmpty()) { // this will be first element
			last = first = new Node(value); // circular

		} else {
			Node node = first;
			first = new Node(value);
			first.next = node;
		}
		N++; // increment the no of items
	}

	/**
	 * removes an item from the beginning of the steque
	 */
	public Item pop() {
		Item value = null;
		if (isEmpty()) {
			return value;// empty list, do nothing
		}
		value = first.item;
		if (size() == 1)
			first = last = null; // now is empty
		else
			first = first.next;
		N--;
		return value;
	}

	/**
	 * add a given item at the end of steque
	 * 
	 * @param value
	 */
	public void enqueue(Item value) {
		if (isEmpty())
			last = first = new Node(value); // circular
		else {
			last.next = new Node(value);
			last = last.next;
		}
		N++;
	}

	// return an object from a linked list that implements the iterator interface;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Iterator iterator() {
		return new StequeIterator();
	}

	@SuppressWarnings("rawtypes")
	private class StequeIterator implements Iterator {
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
	 * print method for steque item
	 * 
	 * @param dll
	 */
	public static void prettyPrint(@SuppressWarnings("rawtypes") Steque_1332 dll) {
		for (Object element : dll) {
			StdOut.print(element + " ");
		}
		StdOut.println("\nsize: " + dll.size());
		StdOut.println("");
	}

	/**
	 * main method with steque tests
	 * 
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("Steque by Victoria Golden\n");

		@SuppressWarnings("rawtypes")
		Steque_1332 steque = new Steque_1332();
		String[] test = { "dogs", "cats", "cow", "chair", "computer" };

		for (int i = 0; i < test.length; i++) {
			steque.push(test[i]);
		}

		StdOut.println("Starting Queue.");
		prettyPrint(steque);
		StdOut.println("Steque after pop.");
		steque.pop();
		prettyPrint(steque);
		StdOut.println("Steque after enqueue.");
		steque.enqueue("thermostat");
		prettyPrint(steque);
		StdOut.println("Steque after push.");
		steque.push("pumpkin");
		prettyPrint(steque);
	}

}