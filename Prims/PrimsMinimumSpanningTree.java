package Prims;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Prims.BinaryMinHeap.Node;

public class PrimsMinimumSpanningTree {
	public static void main(String[] args) {
		int graph[][] = new int[][] {{0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0},
           };
           
        PrimsMinimumSpanningTree mst = new PrimsMinimumSpanningTree();
        mst.findMST(graph);
	}

	private void findMST(int[][] graph) {
		
		BinaryMinHeap<Integer> heap = new BinaryMinHeap<>();
		HashMap edge = new HashMap<>();
		HashMap weight = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		
		heap.add(0, 0);
		int max = Integer.MAX_VALUE;
		for (int i = 1; i < graph.length; i++) {
			heap.add(max, i);
		}
	
		while(visited.size() != graph.length) {
			Node current = heap.extractMin();
			visited.add((Integer) current.key);
			
			for (int i = 0; i < graph.length; i++) {
				if(!visited.contains(i)) {
					if(graph[(int) current.key][i] != 0) {
						if(graph[(int) current.key][i] < heap.getKeyWeight(i)) {
							heap.decrease(i, graph[(int) current.key][i]);
							String temp = current.key + " - " + i; 
							edge.put(i, temp);
							weight.put(i, graph[(int) current.key][i]);
						}
					}
				}	
			}
		}
		
		System.out.println("Edge");
		System.out.println(edge);
		
		System.out.println("weight");
		System.out.println(weight);
		
	}
}
