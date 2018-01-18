package ArticulationPoints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	LinkedList<Integer> adjacentNodes[];
	HashMap<Integer, LinkedList<Integer>> nodeDetails = new HashMap<>();
	int timer = 1;
	HashSet articulationPoints = new HashSet<>();
	
	public Graph(int n) {
		adjacentNodes = new LinkedList[n];
		
		for (int i = 0; i < n; i++) {
			adjacentNodes[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int parent, int child) {
		adjacentNodes[parent].add(child);
		adjacentNodes[child].add(parent);
	}
	
	public void findArticulationPointsDFS() {
		Set<Integer> visited = new HashSet<>();
		recursiveDFS(3, visited, -1);
		
		System.out.println("Articular points are");
		System.out.println(articulationPoints);
	}

	private void recursiveDFS(int nodeIndex, Set<Integer> visited, int parent) {
		boolean morethan2Childs = false;
		if(visited.contains(nodeIndex)) {
			return;
		}
		
		if(!visited.contains(nodeIndex)) {
			visited.add(nodeIndex);
			
			LinkedList<Integer> details = new LinkedList<>();
			details.add(timer);
			details.add(timer);
			details.add(parent);
			nodeDetails.put(nodeIndex, details);
			
			timer++;
			
			for (int j = 0; j < adjacentNodes[nodeIndex].size(); j++) {
				if(parent == -1 && adjacentNodes[nodeIndex].size() >= 2 && j != 0) {
					if( !visited.contains(adjacentNodes[nodeIndex].get(j))) {
						morethan2Childs = true;
					}
				}
				recursiveDFS(adjacentNodes[nodeIndex].get(j), visited, nodeIndex);
			}
		}
		
		int currentNodetimer = nodeDetails.get(nodeIndex).get(0);
		int minimum = Integer.MAX_VALUE;
		if(parent == -1) {
			if(morethan2Childs) {
				articulationPoints.add(nodeIndex);
			}
		} else {
			for (int j = 0; j < adjacentNodes[nodeIndex].size(); j++) {
				
				int childNodeLow = nodeDetails.get(adjacentNodes[nodeIndex].get(j)).get(1);
				minimum = Math.min(minimum, childNodeLow);
//				System.out.println("child index " + adjacentNodes[nodeIndex].get(j)  + " childNodeLow " + childNodeLow + " minimum " + minimum);
				if(currentNodetimer <= childNodeLow) {
					articulationPoints.add(nodeIndex);
				}
			}
			int currentNodeLow = nodeDetails.get(nodeIndex).get(1);
			nodeDetails.get(nodeIndex).set(1, Math.min(currentNodeLow, minimum));
		}
	}
}
