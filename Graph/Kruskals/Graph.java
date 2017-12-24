package Kruskals;
import java.util.Arrays;

public class Graph {
	int V, E;
	int currentEdgeIndex = 0;
	private Edge[] edge;
	public Graph(int noOfVetex, int noOfEdge) {
		V = noOfVetex;
		E = noOfEdge;
		edge = new Edge[noOfEdge];
		
		for (int i = 0; i < edge.length; i++) {
			edge[i] = new Edge();
		}
	}
	
	public class Edge implements Comparable<Edge> {
		public int src, dest, weight;
		
		@Override
		public int compareTo(Edge o) {
			return (this.weight - o.weight);
		}
	}
	
	public void addEdge(int src, int dest, int weight) {
		edge[currentEdgeIndex].src = src;
		edge[currentEdgeIndex].dest = dest;
		edge[currentEdgeIndex].weight = weight;
		currentEdgeIndex++;
	}
	
	public void MST() {
		DisjointSet disjointSet = new DisjointSet(V);
		for (int i = 0; i < V; i++) {
			disjointSet.makeSet(i);
		}
		
		Arrays.sort(edge);
		for (int i = 0; i < edge.length; i++) {
			if(disjointSet.findSet(edge[i].src).data != disjointSet.findSet(edge[i].dest).data) {
				disjointSet.union(edge[i].src, edge[i].dest);
				System.out.println("src "+ edge[i].src + "  dest "+ edge[i].dest + "  weight "+ edge[i].weight);
			}
		}
	}
	
	public void test() {
		for (int i = 0; i < edge.length; i++) {
			System.out.println("src "+ edge[i].src + "  dest "+ edge[i].dest + "  weight "+ edge[i].weight);
		}
		
		System.out.println();
		System.out.println("After sorting");
		Arrays.sort(edge);
		for (int i = 0; i < edge.length; i++) {
			System.out.println("src "+ edge[i].src + "  dest "+ edge[i].dest + "  weight "+ edge[i].weight);
		}
	}
}
