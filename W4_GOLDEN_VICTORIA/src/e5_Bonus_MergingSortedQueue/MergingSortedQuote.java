package e5_Bonus_MergingSortedQueue;

import java.util.Random;

import edu.princeton.cs.algs4.Queue;

/**
 * 
 * @author Victoria Golden
 * Bonus Exercise 2.2.14: Merging sorted queues. Develop a static method that takes two queues
 * of sorted items as arguments and returns a queue that results from merging
 * the queues into sorted order.
 */

public class MergingSortedQuote {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Queue<Comparable> mergeQ(Queue<Comparable> a, Queue<Comparable> b) {
		Queue<Comparable> q = new Queue();
		while (!a.isEmpty() || !b.isEmpty()) {
			if (a.isEmpty())
				q.enqueue(b.dequeue());
			else if (b.isEmpty())
				q.enqueue(a.dequeue());
			else if (a.peek().compareTo(b.peek()) < 0)
				q.enqueue(a.dequeue());
			else
				q.enqueue(b.dequeue());
		}
		return q;
	}
	
	@SuppressWarnings("rawtypes")
	public static void genRandomSortedQueue() {
		Queue<Comparable> a = new Queue<>();
		Queue<Comparable> b = new Queue<>();
		int size = 20;
		int cura = 0;
		int curb = 0;
		Random r = new Random();
		while (--size > 0) {
			cura += r.nextInt(3);
			curb += r.nextInt(3);
			a.enqueue(cura);
			b.enqueue(curb);
		}
		System.out.println("Printing first sorted queue: " + a);
		System.out.println("Printing second sorted queue: " +b);
		System.out.println("Printing merged sorted queue: " + mergeQ(a, b));
		System.out.println("\n");
	}

	public static void main(String[] args) {
		System.out.println("Merge Sorted Queues by Victoria Golden\n");
		
		genRandomSortedQueue();
		genRandomSortedQueue();
		genRandomSortedQueue();
	}
}