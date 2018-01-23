package Graph_Directed_Detect_Cycle;

public class MainClass {
	public static void main(String[] args) {
		 
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        
        if (g1.hasCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
 
	}
}
