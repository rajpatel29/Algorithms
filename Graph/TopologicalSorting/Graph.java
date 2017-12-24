package TopologicalSorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Graph {
	private ArrayList<Integer> nodes[] = null;
	private int numberOfVirtices;
	public Graph(int n) {
		numberOfVirtices = n;
		nodes = new ArrayList[n];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int start, int end) {
		nodes[start].add(end);
	}
	
	public ArrayList<Integer> getChilds(int n) {
		return nodes[n];
	}
	
	public void getTopologicalSorting() {
		Set<Integer> nonVisited = new HashSet<>();
		Stack<Integer> sorted = new Stack<>();
		
		for (int i = 0; i < numberOfVirtices; i++) {
			nonVisited.add(i);
		}
		
		for (int i = 0; i < numberOfVirtices; i++) {
			if (nonVisited.contains(i)) {
				recursiveTopologicalSorting(i , nonVisited, sorted);
			}
		}	
		int stackSize =  sorted.size();
		for (int i = 0; i < stackSize; i++) {
			System.out.println(sorted.pop());
		}
	}
	
	public void recursiveTopologicalSorting(int start, Set<Integer> nonVisited, Stack<Integer> sorted ) {
		if(!nonVisited.contains(start))
			return;
		
		nonVisited.remove(start);
		
		for (int i = 0; i < nodes[start].size(); i++) {
			recursiveTopologicalSorting(nodes[start].get(i), nonVisited, sorted);
		}
		
		sorted.push(start);
	}
}
