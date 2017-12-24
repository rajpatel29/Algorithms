package DijkstraShortestPath;

import java.util.HashSet;
import java.util.Set;

import DijkstraShortestPath.BinaryMinHeap.Node;


public class DijkstraShortestPath {
	public static void main (String[] args)
    {
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        DijkstraShortestPath t = new DijkstraShortestPath();
        t.dijkstra(graph, 0);
    }

	private void dijkstra(int[][] graph, int startNode) {
		Set<Integer> notVisited = new HashSet<>();
		
		//initialize distance
		BinaryMinHeap<Integer> heap = new BinaryMinHeap<Integer>();
		heap.add(0, 0);
		notVisited.add(0);
		
		int max = Integer.MAX_VALUE;
		for(int i = 1 ; i < graph.length; i++) {
			heap.add(max, i);
			notVisited.add(i);	
		}
		
		while(!notVisited.isEmpty()) {
			Node current = heap.extractMin(); 
			int currentKey = (int) current.key;
			int currentWeight = (int) current.weight;
			System.out.println("Node " + currentKey + " => " + currentWeight);
			
			notVisited.remove(currentKey);
			
			for(int i = 0 ; i < graph.length; i++ ) {
				if(graph[currentKey][i] != 0 && notVisited.contains(i)) {
					if(currentWeight + graph[currentKey][i] < heap.getKeyWeight(i)) {
						heap.decrease(i, currentWeight + graph[currentKey][i]);
					}
					
				}
			}
		}
	}
}
