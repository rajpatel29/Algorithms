package DFS;

import java.util.LinkedList;

public class Graph {
	LinkedList<Integer> list[];
	int V = 0;
	public Graph(int n) {
		V = n;
		list = new LinkedList[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int parent, int child) {
		list[parent].add(child);
	}
	
	public void DFS(int n) {
		boolean visited[] = new boolean[V];
		
		recursiveDFS(n, visited);
	}
	
	private void recursiveDFS(int n, boolean[] visited) {
		System.out.println(n);
		visited[n] = true;
		
		for (int i = 0; i < list[n].size(); i++) {
			int currentChild = list[n].get(i);
			if( !visited[currentChild] ) {
				recursiveDFS(currentChild, visited);
			}
		}
	}
}
