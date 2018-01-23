package DetectCycleUndirectedGraph;

public class MainClass {
	public static void main(String[] args) {
		Graph graph = new Graph(3, 3);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);

		System.out.println("Cycle ? " + graph.isCycle());
	}
}
