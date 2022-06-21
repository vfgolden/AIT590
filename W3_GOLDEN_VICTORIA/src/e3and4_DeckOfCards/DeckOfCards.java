package e3and4_DeckOfCards;

/**
 * Exercise 3 - Deck of Cards
 * 
 * Assignment Instructions: Create a class named DeckOfCards that will represent 
 * a deck of cards, represented as a fixed size array of cards. 
 * 
 * Create the following methods: 
 * a constructor with no parameters that will create a deck of cards sorted in the following order
 * 		 (2 diamond, 2 clubs, 2 hearts, 2 spades, 3 diamond, ...); This is not in the sorted order by the Comparable.
 * getCard( position) where position is 0 for the top of the deck and a maximum size for the bottom, return a card
 * shuffle(number of exchanges) - shuffle the deck following the algorithm, generate randomly 
 * 			two indexes for two cards, exchange the two cards in the deck, repeat the process for the number of exchanges times
 * toString()
 * print()
 * All the sorting methods will sort based on the comparable element (suite first, then rank)
 * selectionSort() - sort the deck using selection sort method
 * insertionSort() - sort the deck using insertion sort method
 * shellSort() - sort the deck using shell sort method
 * 
 * Create a test class that will perform 5 relevant tests, for each of the methods implemented. 
 */
import java.util.Random;

import e2_Card.Card;
import e2_Card.Card.CardFace;
import e2_Card.Card.Suit;

public class DeckOfCards {

	private int numSuits = 4;
	public Card deck[]; // array of Card objects
	public final int deckSize = 52; // max number of values
	private Random randomNumbers; // use java Random to generate random numbers

	/**
	 * Card constructor
	 * 
	 * @param position
	 * @return
	 */
	public Card getCard(int position) {
		if (position < deckSize) {
			return deck[position];
		} else {
			return deck[deckSize - 1];
		}
	}

	/**
	 * Deck constructor
	 */
	public DeckOfCards() {
		deck = new Card[deckSize];
		randomNumbers = new Random();

		for (CardFace faceValue : Card.CardFace.values()) {
			for (Suit i : Card.Suit.values()) {
				deck[i.ordinal() + (faceValue.ordinal() * numSuits)] = new Card(faceValue, i);
				System.out.println(deck[i.ordinal() + (faceValue.ordinal() * numSuits)]);

			}
		}
	}

	/**
	 * Moves the top card to the bottom value of the array
	 */
	public void moveTopToBottom() {
		for (int i = deckSize - 1; i > 0; i--) {
			exchange(i, i - 1);
		}
	}

	/**
	 * Sorts the deck then proceeds to use exchange to effectively reverse the order
	 * of the deck with Ace of Spades being first and Two of Diamonds last
	 */
	public void sortFaceDown() {
		DeckOfCards.insertionSort(this.deck, this.deckSize);
		for (int i = 0, j = deckSize - 1; i <= j; i++, j--) {
			exchange(i, j);
		}
	}

	/**
	 * Method to exchange the two top cards
	 */
	public void exchangeTop() {
		exchange(51, 50);
	}

	/**
	 * Method to move the check for value and then move the higher valued card to
	 * the bottom of the deck and continue until all exchanges are made
	 */
	public void dequeueSort() {
		// outer loop to stop sorting when criteria is met
		for (int j = 0; j < 1;) {
			j = 1;
			// inner loop to compare two cards
			for (int i = 0; i < deckSize - 1; i++) {
				Card a = deck[deckSize - 1];
				Card b = deck[deckSize - 2];

				// if the value of a is less than b, swap
				if (a.compareTo(b) < 0) {
					exchangeTop();
					j = 0;
					moveTopToBottom();
				} else {
					j = 1;
				}
			}
		}
	}

	/**
	 * Shuffle the deck using two random indexes
	 * 
	 * @param numExchanges
	 */
	public void shuffle(int numExchanges) {

		for (int i = numExchanges; i > 0; i--) {
			int idx1 = randomNumbers.nextInt(deckSize);
			int idx2 = randomNumbers.nextInt(deckSize);
			exchange(idx1, idx2);
		}
	}

	/**
	 * Method to String
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < deckSize; i++) {
			s += deck[i].toString();
			s += "\n";
		}
		return s;
	}

	/**
	 * print method
	 */
	public void print() {
		System.out.println(this);
	}

	/**
	 * Method for insertion sort, sorts right to left
	 * 
	 * @param name
	 * @param n
	 */
	public static void insertionSort(Card[] deck, int numCards) {
		for (int i = numCards - 1; i > 0; i--) {
			for (int j = i; j < numCards && !less(deck[j - 1], deck[j]); j++)
				exch(deck, j, j - 1);
		}
	}

	/**
	 * exchange method to swap card positions in a deck
	 * 
	 * @param a
	 * @param b
	 */
	private void exchange(int a, int b) {
		Card t = deck[a];
		deck[a] = deck[b];
		deck[b] = t;
	}

	/**
	 * Method to exchange array item positions
	 * 
	 * @param array
	 * @param a
	 * @param b
	 */
	private static void exch(Card[] array, int a, int b) {
		Card t = array[a];
		array[a] = array[b];
		array[b] = t;
	}

	/**
	 * Method to compare if one variable is less than another variable
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean less(Card a, Card b) {
		return a.compareTo(b) < 0;
	}

	/**
	 * Method to selection sort
	 * 
	 * @param name
	 * @param n
	 */
	public static void selectionSort(Card[] deck, int numCards) {
		int min;
		for (int i = 0; i < numCards - 1; i++) {
			min = i;
			for (int j = i + 1; j < numCards; j++)
				if (less(deck[j], deck[min]))
					min = j;
			if (min != i) {
				Card aux = deck[i];
				deck[i] = deck[min];
				deck[min] = aux;
			}
		}
	}

	/**
	 * Method to Shellsort
	 * 
	 * @param name
	 * @param n
	 */
	public static void shellSort(Card[] deck, int numCards) {
		int h = 1;
		while (h < numCards / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < numCards; i++) {
				for (int j = i; j >= h && less(deck[j], deck[j - h]); j -= h) {
					exch(deck, j, j - h);
				}
			}
			h /= 3;
		}
	}
}
