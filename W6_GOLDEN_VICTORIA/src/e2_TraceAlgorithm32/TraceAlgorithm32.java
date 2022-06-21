package e2_TraceAlgorithm32;

import java.util.Arrays;

public class TraceAlgorithm32<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;

	@SuppressWarnings("unchecked")
	public TraceAlgorithm32(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public Value get(Key key) {
		System.out.println("get(" + key + ")");
		if (isEmpty()) {
			System.out.print("array is empty. returning null.");
			return null;
		}
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			System.out.println("Value i = "+keys[i]+" is equal to "+key);
			System.out.println(key + " is the " + vals[i]);
			return vals[i];
		}else {
			System.out.print("Key of " + key + " not found. Returning null.");
			return null;
		}
	}

	private boolean isEmpty() {
		return N == 0;
	}

	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			System.out.println("lo:" + lo + ", hi:" + hi + ", mid:" + mid + ", cmp:" + cmp);
			if (cmp < 0) {
				hi = mid - 1;
				System.out.println("lo:" + lo + ", hi:" + hi + ", mid:" + mid + ", cmp:" + cmp);
			} else if (cmp > 0) {
				lo = mid + 1;
				System.out.println("lo:" + lo + ", hi:" + hi + ", mid:" + mid + ", cmp:" + cmp);
			} else
				return mid;
		}
		return lo;
	}

	public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
		System.out.println("int n = " + N + ";");
		System.out.println("put(" + key + "," + val + ")");
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public void delete(Key key) {
		put(key, null);
	}

	public static void main(String[] args) {
		System.out.println("Exercise 2: Trace Algorithm 3.2 by Victoria Golden");

		TraceAlgorithm32<String, String> array = new TraceAlgorithm32<String, String>(10);

		System.out.println("\nStep 1 Trace");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("V", "first letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("I", "second letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("C", "third letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("T", "fourth letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("O", "fifth letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("R", "sixth letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("M", "seventh letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("A", "eigth letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("G", "ninth letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.put("N", "tenth letter");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");

		System.out.println("\nStep 2 Trace");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.get("R");
		
		System.out.println("\nStep 3 Trace");
		System.out.print("Key[] keys = " + Arrays.toString(array.keys) + "\n");
		System.out.print("Value[] vals = " + Arrays.toString(array.vals) + "\n");
		array.get("Z");
	}
}