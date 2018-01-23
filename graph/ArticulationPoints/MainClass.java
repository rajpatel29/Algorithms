package ArticulationPoints;

public class MainClass {
	public static void main(String[] args) {
		Graph g = new Graph(9);
		         
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);

        g.addEdge(4, 2);
        
        
        g.findArticulationPointsDFS();

	}
}
