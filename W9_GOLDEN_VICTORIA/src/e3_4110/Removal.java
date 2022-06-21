package e3_4110;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import e1_413.Graph;

/**
 * 
 * @author Victoria Golden
 *
 *         Exercise 4.1.10 Prove that every connected graph has a vertex whose
 *         removal (including all adjacent edges) will not disconnect the graph,
 *         and write a DFS method that finds such a vertex. Hint : Consider a
 *         vertex whose adjacent vertices are all marked.
 */

public class Removal {

	public class DepthFirstSearchConnected {

		private boolean[] visited;
		private int count;
		private int vertexThatCanBeRemoved;

		private Graph graph;
		private int sourceVertex;

		public DepthFirstSearchConnected(Graph graph, int sourceVertex) {
			visited = new boolean[graph.V()];

			this.graph = graph;
			this.sourceVertex = sourceVertex;
		}

		public int findVertexThatCanBeRemoved() {
			dfs(graph, sourceVertex);
			return vertexThatCanBeRemoved;
		}

		private void dfs(Graph graph, int vertex) {
			visited[vertex] = true;
			count++;

			boolean areAllNeighborsMarked = true;

			for (int neighbor : graph.adjacent(vertex)) {
				if (!visited[neighbor]) {
					areAllNeighborsMarked = false;
					dfs(graph, neighbor);
				}
			}

			if (areAllNeighborsMarked) {
				vertexThatCanBeRemoved = vertex;
			}
		}

		public boolean marked(int vertex) {
			return visited[vertex];
		}

		public int count() {
			return count;
		}

	}

	public static void main(String[] args) {
		StdOut.println("Exercise 4.1.10 by Victoria Golden");

		Removal removed = new Removal();

		// Use tinyG.txt to test
		In in = new In("https://algs4.cs.princeton.edu/41graph/tinyG.txt");
		// Connected graph
		Graph graph = new Graph(in);
		StdOut.println(graph);

		DepthFirstSearchConnected depthFirstSearchConnected = removed.new DepthFirstSearchConnected(graph, 0);
		StdOut.println("Vertex that can be removed: " + depthFirstSearchConnected.findVertexThatCanBeRemoved()
				+ " vs an expected of 1");
	}

}
