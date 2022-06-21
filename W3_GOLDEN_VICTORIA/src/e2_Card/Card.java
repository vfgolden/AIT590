package e2_Card;

public class Card implements Comparable<Card> {

	/**
	 * Exercise 2 Card - for Exercise 2.1.13 - page 265
	 * 
	 * Assignment Instructions: Create an immutable class named Card implementing
	 * the Comparable interface that will represent a card, have a suit: diamonds -
	 * lowest, clubs, hearts, spades - highest) and a rank ( 2, 3, 4, 5, 6, 7, 8, 9,
	 * 10, J, Q, K, A). The class must have a constructor provided with a suit and
	 * rank, and the following methods: toString(), getSuit(), getRank(), print().
	 * Create a static method that will randomly generate a card. Create a test
	 * class that will perform 5 relevant tests, for each of the methods
	 * implemented. A card is less than another either if the suite is lower or if
	 * they have the suite, then the rank is lower.
	 */

	public static enum Suit {
		Diamond, Club, Heart, Spade
	}

	public static enum CardFace {
		Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
	}

	public static final int DIAMOND = 0;
	public static final int CLUB = 1;
	public static final int HEART = 2;
	public static final int SPADE = 3;
	private CardFace rank;
	private Suit suit;

	/**
	 * Constructor for card to assign a suit and a rank
	 * 
	 * @param rank
	 * @param suit
	 */
	public Card(CardFace rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public int compareTo(Card other) {
		// compareTo should return < 0 if this is supposed to be
		// less than other, > 0 if this is supposed to be greater than
		// other and 0 if they are supposed to be equal
		int x = (this.rank.ordinal() * 4) + this.suit.ordinal();
		int y = (other.rank.ordinal() * 4) + other.suit.ordinal();
		if (x < y) {
			return -1;
		}
		if (x > y) {
			return 1;
		}
		return 0;
	}

	/**
	 * Method to return the rank of a card
	 * 
	 * @return the rank
	 */
	public CardFace getRank() {
		return rank;
	}

	/**
	 * Method to return the suit of a card
	 * 
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Method to determine if a is greater than b and if equal return a statement
	 * indicating equality
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String cardRank(Card a, Card b) {
		if (a.suit.ordinal() > b.suit.ordinal()) {
			return "True";
		} else if (a.suit.ordinal() < b.suit.ordinal()) {
			return "False";
		} else {
			if (a.rank.ordinal() > b.rank.ordinal()) {
				return "True";
			} else if (a.rank.ordinal() < b.rank.ordinal()) {
				return "False";
			} else {
				return "The cards are equal.";
			}
		}
	}

	/**
	 * Return the rank as a String. For example, the 3 of Hearts produces the String
	 * "3". The King of Diamonds produces the String "King".
	 * 
	 * @return the rank String
	 */
	public String getRankString() {
		if (rank == CardFace.Ace) {
			return "Ace";
		} else if (rank == CardFace.King) {
			return "King";
		} else if (rank == CardFace.Queen) {
			return "Queen";
		} else if (rank == CardFace.Jack) {
			return "Jack";
		}
		return "" + rank;
	}

	/**
	 * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
	 * 
	 * @return the suit String
	 */
	public String getSuitString() {
		if (suit.ordinal() == CLUB) {
			return "Clubs";
		}
		if (suit.ordinal() == DIAMOND) {
			return "Diamonds";
		}
		if (suit.ordinal() == HEART) {
			return "Hearts";
		}
		return "Spades";

	}

	/**
	 * Return "?" if the card is facedown; otherwise, the rank and suit of the card.
	 * 
	 * @return the String representation
	 */
	public String toString() {
		String s = "" + getRankString() + " of " + getSuitString();
		return s;
	}

	public static void testCard(Card a, Card b) {
		// testing both toString and print while displaying the compared variables
		System.out.print("The two cards being compared are: ");
		print(a);
		System.out.print(" & ");
		print(b);
		System.out.println();

		// test if suit is same or different
		if (a.getSuit() == b.getSuit()) {
			System.out.println("Suits are the same!");
		} else {
			System.out.println("The suits are not the same.");
		}
		// test is rank is same or different
		if (a.getRank() == b.getRank()) {
			System.out.println("Ranks are the same!");
		} else {
			System.out.println("The ranks are not the same.");
		}
		// Test cardRank Method
		System.out.println("Is card a larger than card b? " + cardRank(a, b));

		System.out.println();

	}

	public static void print(Card a) {
		System.out.print(a.toString());
	}

	public static void main(String[] args) {
		System.out.println("Card by Victoria Golden\n");

		Card a = new Card(CardFace.Five, Suit.Diamond);
		Card b = new Card(CardFace.Queen, Suit.Spade);
		Card c = new Card(CardFace.Ace, Suit.Club);
		Card d = new Card(CardFace.Ace, Suit.Club);

		testCard(a, b);
		testCard(b, a);
		testCard(a, c);
		testCard(d, b);
		testCard(c, d);
	}
}
