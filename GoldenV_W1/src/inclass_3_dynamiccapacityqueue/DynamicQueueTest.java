package inclass_3_dynamiccapacityqueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test DynamicQueueCapacity
 * @author Victoria Golden
 *
 */

class DynamicQueueTest {

	@Test
	void test() {
		DynamicCapacityQueue<Integer> queue = new DynamicCapacityQueue<Integer> (10);
		
		if (queue.getCapacity()!=10) {
			fail("Queue is less than 10");
		}
		
		for (int x = 0; x < 11; x++) queue.enqueue(x);
		System.out.print("Queue capacity: ");
		System.out.println(queue.getCapacity());
		if (queue.getCapacity()!=20) {
			fail("Queue is not equal to 20");
		}
		
		for (int x = 8; x>0; x--) queue.dequeue();
		System.out.print("Queue capacity: ");
		System.out.println(queue.getCapacity());
		if (queue.getCapacity()!=10) {
			fail("Queue is not equal to 10");
		}
	}
}
