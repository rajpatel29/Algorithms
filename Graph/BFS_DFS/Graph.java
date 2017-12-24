package BFS_DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {
	public int numberOfNodes;
	public LinkedList<Integer> edge[];

	public Graph(int n) {
		numberOfNodes = n;
		edge = new LinkedList[n];
		for(int  i = 0 ; i < n ; i++) {
			edge[i] = new LinkedList<>();
		}
	}

	public void addEdge(int start, int end) {
		edge[start].add(end);
	}

	public void DFS(int root) {
		boolean visited[] = new boolean[numberOfNodes];
		DFSHelper(root, visited);
	}

	private void DFSHelper(int root, boolean visited[]) {
		if(visited[root])
			return;

		visited[root] = true;
		System.out.println(root);

		for(int i = 0 ; i < edge[root].size() ; i++) {
			DFSHelper(edge[root].get(i), visited);
		}
	}

	public void BFS(int root) {
		List<Integer> list = new LinkedList<>();
		boolean visited[] = new boolean[numberOfNodes];

		list.add(root);

		int numberOfElements = list.size();
		while(list.size() != 0) {
			for(int i = 0; i < numberOfElements ; i++) {
				int temp = list.get(0);
				list.remove(0);
				visited[temp] = true;

				for(int j = 0 ; j< edge[temp].size(); j++ )	{
					int te = edge[temp].get(j);

					if(!visited[te])
						list.add(te);
				}

				System.out.print(temp + "  ");
			}
			System.out.println();
			numberOfElements = list.size();
		}
	}
}
