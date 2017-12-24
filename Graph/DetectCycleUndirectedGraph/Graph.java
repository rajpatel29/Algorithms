package DetectCycleUndirectedGraph;

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
	
	public class Edge {
		public int src, dest;
	}
	
	public void addEdge(int src, int dest) {
		edge[currentEdgeIndex].src = src;
		edge[currentEdgeIndex].dest = dest;
		currentEdgeIndex++;
	}
	
	public boolean isCycle() {
		DisjointSet disjointSet = new DisjointSet(V);
		for (int i = 0; i < V; i++) {
			disjointSet.makeSet(i);
		}
		
		for (int i = 0; i < edge.length; i++) {
			System.out.println("SRC " + edge[i].src + "DEST " + edge[i].dest);
			if(disjointSet.findSet(edge[i].src).data == disjointSet.findSet(edge[i].dest).data) {
				return true;
			}
			disjointSet.union(edge[i].src, edge[i].dest);
		}
		return false;
	}
}
