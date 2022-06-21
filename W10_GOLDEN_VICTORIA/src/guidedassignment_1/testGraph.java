package guidedassignment_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

class testGraph {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		System.out.println("Guided Assignment 1 by Victoria Golden \n");
		
		// TinyG test
		In in = new In("https://algs4.cs.princeton.edu/41graph/tinyG.txt");
		Digraph G = new Digraph(in);
		StdOut.println("TinyG test");
        StdOut.println(G.detailedPrint());
        
        // MediumG test
        in = new In("https://algs4.cs.princeton.edu/41graph/mediumG.txt");
		Digraph a = new Digraph(in);
		StdOut.println("MediumG test");
        StdOut.println(a.detailedPrint());
        
        // LargeG test
        in = new In("https://algs4.cs.princeton.edu/41graph/largeG.txt");
		Digraph b = new Digraph(in);
		StdOut.println("LargeG test");
        StdOut.println(b.detailedPrint());
	}

}
