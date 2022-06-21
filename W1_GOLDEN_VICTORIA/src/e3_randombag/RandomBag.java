package e3_randombag;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;


/**
 * @author Victoria Golden
 */
public class RandomBag<Item> implements Iterable<Item> {


    private Item[] arr;
    private int items;

    /**
     * Construct a bag with a given capacity.
     * @param a capacity.
     */
    @SuppressWarnings("unchecked")
	public RandomBag(int a) {
        arr = (Item[]) new Object[a];
        items = 0;
    }

    /**
     * Method to return true if the bag is empty
     *
     * @return true if number of items is equal to 0
     */
    public boolean isEmpty() {
        return items == 0;
    }

    /**
     * Method to return the number of items in the bag
     *
     * @return items, number of items in bag
     */
    public int size() {
        return items;
    }

    /**
     * Add Item value to items
     *
     * @param value
     */
    public void add(Item value) {
        arr[items] = value;
        items++;
    }

    /**
     * Shuffle the bag and return a new BagIterator
     *
     * @return BagIterator
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Iterator iterator() {
        StdRandom.shuffle(arr, 0, items - 1);
        return new BagIterator();
    }

    /**
     * Method provides functions for next, remove, and has next
     */
    @SuppressWarnings("rawtypes")
	private class BagIterator implements Iterator {
        private int i = 0;

        public boolean hasNext() {
            return i < items;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item value = arr[(i) % arr.length];
            i++;
            return value;
        }

        public void remove() {

        }
    }
    
    /**
     * Print method for printing a string array
     * @param array String array for printing
     */
    private static void printStringArray(String[] array) {
    	for (String i : array) { 
            System.out.print(i + " "); 
        }
    }

    /**
     * Testing class for the RandomBag class
     * @param title Title of the test run.
     * @param string the string array that contains items.
     */
    public static void testingRandomBag(String title, String[] string) {
        System.out.print(title + "\n");
        printStringArray(string);
        System.out.println("\nFilling the bag with " + string.length + " items.");
        RandomBag randBag = new RandomBag(string.length);

        for (int i = 0; i < string.length; i++) {
            randBag.add(string[i]);
        }
        System.out.println("\nThe shuffled bag will now be: ");
        Iterator iterator = randBag.iterator();
        while (iterator.hasNext()) {
            Object s = iterator.next();
            if (s == null) {
                continue;
            }
            System.out.print(s + " ");
        }
        System.out.println("\n");

    }

    /**
     * Main method to contain test arrays and execute test methods.
     * @param args none.
     */
    public static void main(String[] args) {
        System.out.println("Random Bag by Victoria Golden\n");

        String[] test1 = {"turtle", "snake", "tortoise", "boa"};
        testingRandomBag("Test 1", test1);

        String[] test2 = {"cheesecake", "cake", "pie"};
        testingRandomBag("Test 2", test2);

        String[] test3 = {"milk", "juice", "coffee", "tea"};
        testingRandomBag("Test 3", test3);

        String[] test4 = {"camaro", "mustang", "gti", "raptor"};
        testingRandomBag("Test 4", test4);

        String[] test5 = {"NYC", "DFW", "IAD", "BWI", "HND"};
        testingRandomBag("Test 5", test5);
    }
}