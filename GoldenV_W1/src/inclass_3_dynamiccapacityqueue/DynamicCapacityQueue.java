package inclass_3_dynamiccapacityqueue;

public class DynamicCapacityQueue<Item> implements Queue<Item> {
	/**
	 * Returns an integer denoting the capacity of the queue
	 * 
	 * @return int denoting the current capacity of the queue
	 */
	private int capacity;

	/**
	 * The array of items with the given capacity.
	 */
	private Item[] items;

	/**
	 * The current size of a queue.
	 */
	private int size;

	/**
	 * Method to return the current value of capacity
	 * 
	 * @return the value of capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
		 * Construct a queue that can be resized based upon the current given capacity
		 * 
		 * @param capacity
		 */
		@SuppressWarnings("unchecked")
		public DynamicCapacityQueue(int capacity) {
			this.capacity = capacity;
			this.items = ((Item[]) new Object[capacity]);
			this.size = 0;
		}

	/**
	 * method to double the capacity of the queue when 3/4 size is reached and copy
	 * the items
	 */
	@SuppressWarnings("unchecked")
	private void doubleCapacity() {
		// initialize a new item array
		Item[] newItems = ((Item[]) new Object[(capacity == 0) ? 1 : capacity * 2]);
		// copy the newly created items
		for (int i = 0; i < this.size; i++)
			newItems[i] = items[i];
		// set items and capacity to the new size
		capacity = newItems.length;
		items = newItems;
	}

	/**
	 * Method to half the capacity of the queue when the 1/4 size of queue is being
	 * utilized
	 */

	private void halfCapacity() {
		// create new items
		@SuppressWarnings("unchecked")
		Item[] newItems = ((Item[]) new Object[(capacity == 0) ? 1 : capacity / 2]);
		// copy the current items
		for (int i = 0; i < size; i++)
			newItems[i] = items[i];
		// update the instance variables to the newly doubled ones
		capacity = newItems.length;
		items = newItems;
	}

	/**
	 * Add an item to the queue.
	 * 
	 * @param item, added item
	 */
	public void enqueue(Item item) {
		if (size == capacity) {
			doubleCapacity();
		}
		items[size++] = item;
	}

	/**
	 * Remove the oldest item from the queue
	 * 
	 * @return item, removed item
	 */

	public Item dequeue() {
		Item result = items[0];
		for (int i = 0, len = size - 1; i < len; i++) {
			items[i] = items[i + 1];
		}
		size--;
		if (size < capacity / 3) {
			halfCapacity();
		}
		return result;
	}

	/**
	 * Boolean to return true if the queue is empty, otherwise false
	 * 
	 * @return true
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns an integer denoting the size of the queue
	 * 
	 * @return int denoting the size of the queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Return a string representation of the queue using toString for each item, in
	 * the format: queue(size/capacity):[item1, item2, ... ]
	 * 
	 * @return a string representation of the queue
	 */
	public String toString() {
		String result = "";
		result += "Queue";
		result += "(" + size + "/" + capacity + "):";
		result += "[";
		String separator = "";
		for (int i = 0; i < size; i++) {
			Item item = items[i];
			result += separator + item.toString();
			separator = ", ";
		}
		result += "]";
		return result;
	}
}
