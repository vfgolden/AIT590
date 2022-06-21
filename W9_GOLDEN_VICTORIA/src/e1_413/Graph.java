package e1_413;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Victoria Golden
 *
 *         Implement the class Graph Implement a detailedPrint() method that
 *         will show in the output (for tinyG.txt, page 522, 524): Number of
 *         vertices: 13 Number of edges: 13 adj[0] = (6, 2, 1, 5) adj[1] = (0)
 *         adj[2] = (0) adj[3] = (5, 4) ... Implement TestGraph class that will
 *         read the description of a graph and print the detailed description
 *         Test with tinyG.txt; mediumG.txt; largeG.txt
 * 
 *         Graph code from book with modifications for assignment
 */

public class Graph implements GraphInterface {
	private final int vertices;
	protected int edges;
	private Bag<Integer>[] adjacent;

	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.vertices = vertices;
		this.edges = 0;
		adjacent = (Bag<Integer>[]) new Bag[vertices];

		for (int vertex = 0; vertex < vertices; vertex++) {
			adjacent[vertex] = new Bag<>();
		}
	}

	public Graph(In in) {
		this(in.readInt());
		int edges = in.readInt();

		for (int i = 0; i < edges; i++) {
			int vertex1 = in.readInt();
			int vertex2 = in.readInt();
			addEdge(vertex1, vertex2);
		}
	}

	public int V() {
		return vertices;
	}

	public int E() {
		return edges;
	}

	public void addEdge(int vertex1, int vertex2) {
		adjacent[vertex1].add(vertex2);
		adjacent[vertex2].add(vertex1);
		edges++;
	}

	public Bag<Integer>[] getAdjacencyList() {
		return adjacent;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateAdjacencyList(int vertex, Bag adjacencyList) {
		adjacent[vertex] = adjacencyList;
	}

	public Iterable<Integer> adjacent(int vertex) {
		return adjacent[vertex];
	}

	public int degree(int vertex) {
		return adjacent[vertex].size();
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int vertex = 0; vertex < V(); vertex++) {
			stringBuilder.append(vertex).append(": ");

			for (int neighbor : adjacent(vertex)) {
				stringBuilder.append(neighbor).append(" ");
			}
			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}

	/**
	 * Unit tests the {@code Graph} data type.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		In in = new In("https://algs4.cs.princeton.edu/41graph/tinyG.txt");
		Graph G = new Graph(in);
		StdOut.println(G);
	}

}