package inClass_SymbolTableMethods;

public class SequentialSearchST<Key extends Comparable<Key>, Value> {

	private Node first;
	private static int N = 0;
	private Key[] keys;
	private Value[] vals;

	private class Node { // linked-list node
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	/**
	 * get method; retrieved from Algorithms book
	 * @param key
	 * @return
	 */
	public Value get(Key key) { // Search for key, return associated value.
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key))
				return x.val; // search hit
		return null; // search miss
	}

	/**
	 * put method; retrieved from Algorithms book
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				x.val = val;
				return;
			} // Search hit: update val.
		first = new Node(key, val, first); // Search miss: add new node.
	}

	/**
	 * removes the specified key and value lazy version
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		put(key, null);
	}

	/**
	 * check to see if specified key is present
	 * @param key
	 * @return
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}

	/**
	 * boolean check to see if symbol table is empty
	 * @return
	 */
	public static boolean isEmpty() {
		return N == 0;
	}

	/**
	 * return the size of the symbol table
	 * @return
	 */
	public static int size() {
		return N;
	}

	/**
	 * identify the key in the table with the lowest value
	 * @return
	 */
	public Key min() {
		Key min = first.key;
		for (Node x = first.next; x != null; x = x.next)
			if (min.compareTo(x.key) > 0) {
				min = x.key;
			}
		return min;
	}

	/**
	 * identify the key in the table with the highest value
	 * @return
	 */
	public Key max() {
		Key max = first.key;
		for (Node x = first.next; x != null; x = x.next)
			if (max.compareTo(x.key) < 0) {
				max = x.key;
			}
		return max;
	}

	/**
	 * returns the closest value to given key that is less than or equal
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		Key floor = min();
		for (Node x = first.next; x != null; x = x.next)
			if ((floor.compareTo(x.key) <= 0) && (x.key.compareTo(key) <= 0)) {
				floor = x.key;
			}
		return floor;
	}

	/**
	 * returns the closest value to given key that is greater than or equal
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		Key ceiling = max();
		for (Node x = first.next; x != null; x = x.next)
			if ((ceiling.compareTo(x.key) >= 0) && (x.key.compareTo(key) >= 0)) {
				ceiling = x.key;
			}
		return ceiling;
	}

	/**
	 * find the number of keys less than a given key
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			} else if (cmp > 0) {
				lo = mid + 1;
			} else
				return mid;
		}
		return lo;
	}

	/**
	 * find the key with a given rank
	 * @param k
	 * @return
	 */
	public Key select(int k) {
		return keys[k];
	}

	/**
	 * removes the key and associated values of the smallest key
	 */
	public void deleteMin() {
		delete(min());
	}

	/**
	 * removes the key and associated values of the largest key
	 */
	public void deleteMax() {
		delete(max());
	}
	
	/**
	 * returns the size of the table between two given keys
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int size(Key lo, Key hi) {
		if (hi.compareTo(lo) < 0)
			return 0;
		else if (contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo);

	}

	public static void main(String[] args) {
		System.out.println("Week 6 Class Activity: Implement ST with APIs by Victoria Golden");

	}
}
