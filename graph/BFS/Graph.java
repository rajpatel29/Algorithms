package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	LinkedList<Integer> list[];
	
	public Graph(int n) {
		list = new LinkedList[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int parent, int child) {
		list[parent].add(child);
	}
	
	public void BFS() {
		LinkedList<Integer> allNodes = new LinkedList<>();
		allNodes.add(1);
		Set<Integer> visited = new HashSet();
		visited.add(1);
		while(!allNodes.isEmpty()) {
			int currentNode = allNodes.removeFirst();
			System.out.println(currentNode);
			for (int i = 0; i < list[currentNode].size(); i++) {
				int child = list[currentNode].get(i);
				if(!visited.contains(child)) {
					allNodes.add(child);
				}
				visited.add(child);
			}
		}
	}
}
