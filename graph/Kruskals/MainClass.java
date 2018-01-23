package Kruskals;

public class MainClass {
	public static void main(String args[]) {

//        Graph graph = new Graph(4, 5);
//        
//        graph.addEdge(0, 1, 10);
//        graph.addEdge(0, 2, 6);
//        graph.addEdge(0, 3, 5);
//        graph.addEdge(1, 3, 15);
//        graph.addEdge(2, 3, 4);
        
		Graph graph = new Graph(5, 7);
		
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 3, 6);
		
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 8);
		graph.addEdge(1, 4, 5);
		
		graph.addEdge(2, 4, 7);
		graph.addEdge(3, 4, 9);
     
//		graph.test();
        graph.MST();
	}
}
