package Graph_Undirected_Detect_Cycle;

import java.util.*;
 
// Like directed graphs, we can use DFS to detect cycle in an undirected graph in O(V+E) time. 
// We do a DFS traversal of the given graph. For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited 
// and u is not parent of v, then there is a cycle in graph. If we don’t find such an adjacent for any vertex, we say that there is no cycle. 
// The assumption of this approach is that there are no parallel edges between any two vertices.

class Graph
{
   private int no_Of_Vertices;
   private LinkedList<Integer>[] adj_List;
   
   public Graph(int num) {
	   no_Of_Vertices = num;
	   adj_List = new LinkedList[num];
	   for(int i = 0 ; i < num ; i++) {
		   adj_List[i] = new LinkedList<Integer>(); 
	   }
   }
   
   public void addEdge(int to, int from) {
	   adj_List[to].add(from);
	   adj_List[from].add(to);
   }

	public boolean isCyclic() {
		if(adj_List == null)
			return false;
		
		boolean visited[] = new boolean[no_Of_Vertices];
		
		for (int i = 0; i < no_Of_Vertices; i++ ) {
			if(!visited[i]) {
				if(cyclicHelper(i , visited, -1))
					return true;
			}
		}
		
		return false;
	}

	private boolean cyclicHelper(int node, boolean[] visited, int parent) {
		visited[node] = true;
		
		LinkedList<Integer> childs = adj_List[node];
		
		for(int i=0; i < childs.size() ; i++) {
			if(!visited[childs.get(i)]) {
				if( cyclicHelper(childs.get(i), visited, node) )
					return true;
			}
			
			else if (childs.get(i) != parent)
				return true;
		}
		return false;
	}
}
