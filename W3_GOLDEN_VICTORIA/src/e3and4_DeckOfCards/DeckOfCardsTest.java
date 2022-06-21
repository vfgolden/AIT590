package e3and4_DeckOfCards;

import org.junit.jupiter.api.Test;

public class DeckOfCardsTest {

	@Test
	void test() {
		
		System.out.println("Deck of Cards test for all related exercises by Victoria Golden \n");
		
		System.out.println("Deck of Cards:");
		DeckOfCards x = new DeckOfCards();
		// Testing getCard()
		System.out.println("\n------ getCard Method Test------");
		System.out.println(x.getCard(0));
		System.out.println(x.getCard(53));
		// Testing shuffle()
		System.out.println("\n------ shuffle Method Test------");
		x.shuffle(1);
		System.out.println(x);
		// Testing print()
		System.out.println("------print Method Test------");
		x.print();
		// Testing selectionSort()
		System.out.println("------Selection Sort Test------");
		DeckOfCards.selectionSort(x.deck,x.deckSize);
		x.print();
		x.shuffle(1);
		// Testing insertionSort()
		System.out.println("------Insertion Sort Test------");
		DeckOfCards.insertionSort(x.deck,x.deckSize);
		x.print();
		x.shuffle(1);
		// Testing shellSort
		System.out.println("------Shell Sort Test------");
		DeckOfCards.shellSort(x.deck,x.deckSize);
		x.print();
		// Testing exchange() 
		System.out.println("------exchange Method Test----");
		x.sortFaceDown();
		x.print();
		// Testing moveTopToBottom()
		System.out.println("------move top to bottom test----");
		x.moveTopToBottom();
		x.print();
		// Testing dequeueSort()
		System.out.println("------dequeue test----");
		x.dequeueSort();
		x.print();
	}
	
}
