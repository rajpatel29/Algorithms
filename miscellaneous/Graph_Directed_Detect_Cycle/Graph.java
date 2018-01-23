package Graph_Directed_Detect_Cycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// When doing a DFS, any node is in one of three states - before being visited, during recursively visiting its descendants, 
// and after all its descendants have been visited (returning to its parent, i.e., wrap-up phase). The three colors correspond to 
// each of the three states. One of the reasons for mentioning colors and time of visit and return is to explicitly make these distinctions 
// for better understanding.

// When doing a DFS, any node is in one of three states - before being visited, during recursively visiting its descendants, 
// and after all its descendants have been visited (returning to its parent, i.e., wrap-up phase). The three colors correspond to each of 
// the three states. One of the reasons for mentioning colors and time of visit and return is to explicitly make these distinctions for better 
// understanding.

// Of course, there are actual uses of these colors. Consider a directed graph GG. Suppose you want to check GG for the existence of cycles.
// In an undirected graph, if the node under consideration has a black or grey neighbor, it indicates a cycle (and the DFS does not visit it as
// you mention). However, in case of a directed graph, a black neighbor does not mean a cycle. For example, consider a graph with 3 vertices 
// - A,B,A,B, and CC, with directed edges as A→BA→B, B→CB→C, A→CA→C. Suppose the DFS starts at AA, then visits BB, then CC. When it has returned
// to AA, it then checks that CC has already been visited and is black. But there is no cycle in the graph.

// In a directed graph, a cycle is present if and only if a node is seen again before all its descendants have been visited. 
// In other words, if a node has a neighbor which is grey, then there is a cycle (and not when the neighbor is black). 
// A grey node means we are currently exploring its descendants - and if one such descendant has an edge to this grey node, 
// then there is a cycle. So, for cycle detection in directed graphs, you need to have 3 colors. There could be other examples too, 
// but you should get the idea.


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
   }
   
   public boolean hasCycle() {	
	   Set<Integer> whiteSet = new HashSet();
	   Set<Integer> greySet = new HashSet();
	   Set<Integer> blackSet = new HashSet();
	   HashMap<Integer, Integer> map = new HashMap<>();
	   
	   for(int i = 0 ; i < no_Of_Vertices; i++) {
		   whiteSet.add(i);
	   }
	   
	   while (whiteSet.size() > 0) {
		   Integer current = whiteSet.iterator().next();
		   map.put(current, -1);
		   if(isCycle(current, whiteSet, greySet, blackSet, map) ) {
			   return true;
		   }
	   }
	   
	   return false;
	}

	private boolean isCycle(int currentNode, Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blackSet,
			HashMap<Integer, Integer> map) {
		
		
		whiteSet.remove(currentNode);
		greySet.add(currentNode);
		
		for (int i = 0; i < adj_List[currentNode].size(); i++) {
			int child = adj_List[currentNode].get(i);
			map.put(child, currentNode);
			
			if(greySet.contains(child)) {
				return true;
			} else if (isCycle(child, whiteSet, greySet, blackSet, map)) {
				return true;
			}
		}
		
		greySet.remove(currentNode);
		blackSet.add(currentNode);
		
		
		System.out.println("white Set "  + whiteSet + "  Grey Set" + greySet + " black Set" + blackSet );
		
		return false;
	}	
}
