package e4_LinkedListMergeSort;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListMergeSort {

	public static class Node {
		@SuppressWarnings("rawtypes")
		Comparable val;
		Node next;

		@SuppressWarnings("rawtypes")
		Node(Comparable x) {
			val = x;
		}

		public String toString() {
			Node current = this;
			StringBuilder sb = new StringBuilder();
			while (current != null) {
				sb.append(current.val + " ");
				current = current.next;
			}
			return sb.toString();
		}
	}

	public static class MergeList {
		// Get Node with min value and make it head of list
		@SuppressWarnings("rawtypes")
		private static Node getMin(Node a) {
			Comparable minVal = a.val;
			Node current = a;
			Node minNode = null;
			while (current.next != null) {
				if (less(current.next.val, minVal)) {
					minNode = current;
					minVal = current.next.val;
				}
				current = current.next;
			}
			if (minNode == null)
				return a;
			// Node with min value is minNode.next
			Node tmp = minNode.next.next;
			Node actualMinNode = minNode.next;
			actualMinNode.next = a;
			minNode.next = tmp;
			return actualMinNode;
		}

		public static Node sort(Node a) {
			// Get minimum node
			a = getMin(a);
			Node root = a;
			while (true) {
				Node lo = root.next;
				Node mid = lo;
				while (mid.next != null && !less(mid.next.val, mid.val)) {
					mid = mid.next;
				}
				if (mid.next == null) {
					if (root == a)
						return a; // sorted
					root = a;
					continue;
				}
				Node hi = mid.next;
				while (hi.next != null && !less(hi.next.val, hi.val))
					hi = hi.next;
				merge(root, lo, mid, hi);
				if (hi.next == null) {
					if (root == a)
						return a; // sorted
					root = a;
				} else {
					root = hi;
				}
			}
		}

		public static void merge(Node root, Node lo, Node mid, Node hi) {
			Node curLeft = lo;
			Node curRight = mid.next;
			Node curRoot = root;
			Node stopLeft = mid.next;
			Node stopRight = hi.next;
			while (curLeft != stopLeft || curRight != stopRight) {
				if (curLeft == stopLeft) {
					curRoot.next = curRight;
					curRight = curRight.next;
				} else if (curRight == stopRight) {
					curRoot.next = curLeft;
					curLeft = curLeft.next;
				} else if (less(curLeft.val, curRight.val)) {
					curRoot.next = curLeft;
					curLeft = curLeft.next;
				} else {
					curRoot.next = curRight;
					curRight = curRight.next;
				}
				curRoot = curRoot.next;
			}
			curRoot.next = stopRight;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		private static boolean less(Comparable v, Comparable w) {
			return v.compareTo(w) < 0;
		}

		public static boolean isSorted(Node a) {
			while (a.next != null) {
				if (less(a.next.val, a.val))
					return false;
				a = a.next;
			}
			return true;
		}
	}
	
	/**
	 * Method to generate a random linked list
	 * @param size
	 * @return
	 */
	public static LinkedList<Integer> randomLL(int size) {
        LinkedList<Integer> ll = new LinkedList<>();  
        Random r = new Random();
        while (size>0) {
        	ll.add(r.nextInt());
        	size--;
        }
		return ll;
	}

	/**
	 * Testing main method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Linked List Merge Sort by Victoria Golden\n");
		
		int n = 30;
		Random r = new Random();
		Node head = new Node(n);
		Node current = head;
		
		LinkedList<Integer> rq = randomLL(100);
		
		for (int i = 0; i < n; i++) {
			Node next = new Node(rq.remove());
			current.next = next;
			current = next;
		}
		System.out.println("Linked list prior to sorting: " + head);
		head = MergeList.sort(head);
		System.out.println("Sorted linked list: " + head);

		for (int t = 0; t < 100; t++) {
			head = new Node(r.nextInt());
			current = head;
			for (int i = 0; i < n; i++) {
				Node next = new Node(r.nextInt());
				current.next = next;
				current = next;
			}
			head = MergeList.sort(head);
			if (!MergeList.isSorted(head))
				System.out.printf("List is not sorted.");
		}
	}
}
