package e2_deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Victoria Golden
 *
 * @param <Item>
 * 
 *               Resizing Array Deque to support exercise 1.3.33 from book
 */

public class ResizingArrayDeque<Item> implements Iterable<Item> {

	private Item[] array;
	private int elements;
	private int first;
	private int last;

	public ResizingArrayDeque() {
		array = (Item[]) new Object[2];
		elements = 0;
		first = 0;
		last = 0;
	}

	public static void main(String[] args) {
		System.out.println("Resizing Array Deque by Victoria Golden");

	}

	// return true if linked list is empty
	public boolean isEmpty() {
		return elements == 0;
	}

	// return size of linked list
	public int size() {
		return elements;
	}

	private void resize(int capacity) {
		assert capacity >= elements;
		// copy whole array into a double sized one
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < elements; i++) {
			temp[i] = array[i];
		}
		array = temp;
		first = 0;
		last = elements;
	}

	public void pushLeft(Item item) {
		// if required, double size of array
		if (elements == array.length)
			resize(2 * array.length);
		// shift array elements 2 step ahead
		for (int i = elements - 1; i >= 0; i--)
			array[i + 1] = array[i];
		array[0] = item;
		if (last == array.length)
			last = 0;
		elements++;
	}

	public void pushRight(Item item) {
		// if required, double size of array
		if (elements == array.length)
			resize(2 * array.length);
		array[elements++] = item; // add item
		if (last == array.length)
			last = 0; // wrap around to 0
		elements++;
	}

	// pop out element from beginning of array
	public Item popLeft() {
		if (isEmpty())
			throw new NoSuchElementException("Deque underflow");
		Item item = array[first];
		array[first] = null; // avoid loitering
		first++;
		if (first == array.length)
			first = 0; // wrap around to 0
		elements--; // decrease item count
		// if required decrease size of array
		if (elements > 0 && elements == array.length / 4)
			resize(array.length / 2);
		return item;
	}

	public Item popRight() {
		if (isEmpty())
			throw new NoSuchElementException("Deque underflow");
		Item item = array[elements - 1];
		array[elements - 1] = null;
		if (first == array.length)
			first = 0;
		elements--;
		// if required decrease size of array
		if (elements > 0 && elements == array.length / 4)
			resize(array.length / 2);
		return item;
	}

	@Override
	public Iterator iterator() {
		return new DequeIterator();
	}

	// implement a nested class which implements the iterator interface
	private class DequeIterator implements Iterator {
		private int i = 0;

		public boolean hasNext() {
			return i < elements;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = array[(i + first) % array.length];
			i++;

			return item;
		}

		public void remove() {

		}
	}
}
