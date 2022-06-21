package inclass_3_dynamiccapacityqueue;

public class TestDynamicCapacityQueue<Item> {
	
	/**
	 * Test the constructor of an empty queue with the resizing capacity. Print the operation summary.
	 * @param capacity The capacity of the queue
	 * @return the constructed queue
	 */
	public DynamicCapacityQueue<Item> testQueueConstructor(int capacity) {
		DynamicCapacityQueue<Item> result = new DynamicCapacityQueue<>(capacity);
		System.out.println(result.toString());
		return result;
	}
	
	/**
	 * Test and print the result if the queue is empty.
	 * @param queue The tested queue.
	 * @return the result, true if empty
	 */
	public boolean testIsEmpty(DynamicCapacityQueue<Item> queue) {
		boolean result = queue.isEmpty();
		System.out.println(queue.toString()+" is empty? - "+result);
		return result;
	}
	
	/**
	 * Test and print the result for the size of the queue.
	 * @param queue The tested queue.
	 * @return the current size of the queue.
	 */
	public int testSize(DynamicCapacityQueue<Item> queue) {
		int size = queue.size();
		System.out.println(queue.toString()+" has size "+size);
		return size;
	}
	
	/**
	 * Test and print the result for adding an item to the queue.
	 * @param queue The tested queue.
	 * @param item The added item.
	 */
	public void testEnqueue(DynamicCapacityQueue<Item> queue, Item item) {
		System.out.print(queue.toString()+" .enqueue("+item.toString()+") -> ");
		queue.enqueue(item);
		System.out.println(queue.toString());
	}	
	
	/**
	 * Test and print the result for removing an item from the queue.
	 * @param queue The tested queue.
	 * @param item The added item.
	 */
	public void testDequeue(DynamicCapacityQueue<Item> queue) {
		System.out.print(queue.toString()+" .dequeue() -> ");
		queue.dequeue();
		System.out.println(queue.toString());
	}	
	
	
	/**
	 * Construct and run a test for a resizing capacity queue with the given test data. 
	 * @param testData An array with the test data
	 */
	public TestDynamicCapacityQueue(String testTitle, Item[] testData) {
		System.out.println(testTitle);
		DynamicCapacityQueue<Item> queue = testQueueConstructor(0);
		testIsEmpty(queue);
		testSize(queue);
		for (Item item:testData) {
			System.out.println();
			testEnqueue(queue, item);
			testIsEmpty(queue);
			testSize(queue);			
		}
		for (int i=0, len = testData.length; i<len; i++) {
			System.out.println();
			testDequeue(queue);
			testIsEmpty(queue);
			testSize(queue);				
		}
		System.out.println();
	}
	
	/**
	 * The main test method calling various tests on the queue.
	 * @param args Command line arguments not used
	 */
	public static void main(String[] args) {
		System.out.println("Test DynamicCapacityQueue by Victoria Golden");
		System.out.println();		
		
		String[] test1 = {"a", "b", "c", "d", "e", "f"};
		new TestDynamicCapacityQueue<>("Test a queue of strings:", test1);
		
		Integer[] test2 = {2, 8, 3, 1, 6, 7, 4};
		new TestDynamicCapacityQueue<>("Test a queue of integers:", test2);
	}
}
