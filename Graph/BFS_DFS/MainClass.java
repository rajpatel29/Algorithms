package BFS_DFS;

import java.util.LinkedList;
import java.util.Stack;

public class MainClass {
	public static void main(String args[])
    {
        Graph g = new Graph(8);

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);

        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");

        g.DFS(1);

    }
}
