package Prims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BinaryMinHeap<T> {
	public class Node {
		int weight;
		T key;
	}
	//stores all the nodes in proper order at any given time (just like heap)
	private List<Node> allNodes = new ArrayList<Node>();
	//to get current index of a given key/node in the list
	public HashMap<T, Integer> nodePosition = new HashMap<>();
	
	public void add(int weight, T key) {
		Node currentNode = new Node();
		currentNode.weight = weight;
		currentNode.key = key;
		allNodes.add(currentNode);
		
		int currentNodeIndex = allNodes.size() - 1;
		int parentNodeIndex = (currentNodeIndex - 1) /2;
		nodePosition.put(key, currentNodeIndex);
		
		while(currentNodeIndex > 0 && allNodes.get(parentNodeIndex).weight > allNodes.get(currentNodeIndex).weight) {
			Node parentNode = allNodes.get(parentNodeIndex);
			currentNode = allNodes.get(currentNodeIndex);
			
			//swap
			swap(parentNode, currentNode, parentNodeIndex, currentNodeIndex);
			
			//update parent & current node index
			currentNodeIndex = parentNodeIndex;
			parentNodeIndex = (currentNodeIndex - 1) /2;

		}
	}
	
	public void decrease(T data, int newWeight) {
		int currentIndex = nodePosition.get(data);
		Node currentNode = allNodes.get(currentIndex);
		currentNode.weight = newWeight;
		
		int currentNodeIndex = currentIndex;
		int parentNodeIndex = (currentNodeIndex - 1) /2;
	
		while(currentNodeIndex > 0 && allNodes.get(parentNodeIndex).weight > allNodes.get(currentNodeIndex).weight) {
			Node parentNode = allNodes.get(parentNodeIndex);
			currentNode = allNodes.get(currentNodeIndex);
			
			//swap
			swap(parentNode, currentNode, parentNodeIndex, currentNodeIndex);
			
			//update parent & current node index
			currentNodeIndex = parentNodeIndex;
			parentNodeIndex = (currentNodeIndex - 1) /2;
		}
	}
	
	public void swap(Node node1, Node node2, int node1Index, int node2Index) {
		
		int tempWeight = node1.weight;
		T tempKey = node1.key;
		
		node1.weight = node2.weight;
		node1.key = node2.key;
		
		node2.weight = tempWeight;
		node2.key = tempKey;
		
		nodePosition.remove(node1.key);
		nodePosition.remove(node2.key);
		nodePosition.put(node1.key, node1Index);
		nodePosition.put(node2.key, node2Index);
	}
	
	public Node extractMin() {
		if(allNodes.size() == 0)
			return null;
		
		Node answer = new Node();
		answer.key = allNodes.get(0).key;
		answer.weight = allNodes.get(0).weight;
		
		if(allNodes.size() == 1) {
			allNodes.remove(0);
			nodePosition.remove(answer.key);
		} else {
			Node firstNode = allNodes.get(0);
			Node lastNode = allNodes.get(allNodes.size() -1);
			swap(firstNode, lastNode, 0, allNodes.size() -1);
			
			//remove last node
			allNodes.remove(allNodes.size() -1);
			nodePosition.remove(answer.key);
			
			Node currentNode = firstNode;
			int currentNodeIndex = 0;
			int lastIndex = allNodes.size() -1;
			
			while (true) {
				int childIndex1 = ( currentNodeIndex * 2 ) + 1;
				int childIndex2 = ( currentNodeIndex * 2 ) + 2;
				if(childIndex1 > lastIndex) {
					break;
				} else if(childIndex2 > lastIndex) {
					if(allNodes.get(childIndex1).weight < currentNode.weight) {
						swap(allNodes.get(childIndex1), currentNode, childIndex1, currentNodeIndex);
					}
					break;
				} else {
					int childIndex;
					if(allNodes.get(childIndex1).weight < allNodes.get(childIndex2).weight) {
						childIndex = childIndex1;
					} else {
						childIndex = childIndex2;
					}
					
					if(allNodes.get(childIndex).weight < currentNode.weight) {
						swap(allNodes.get(childIndex), currentNode, childIndex, currentNodeIndex);
						currentNode = allNodes.get(childIndex);
						currentNodeIndex = childIndex;
					} else {
						break;
					} 
				}
			}		
		}
		
		return answer;
	}
	
	public int getKeyWeight(T key) {
		return allNodes.get(nodePosition.get(key)).weight;
	}
	
	
	
	public void printAllNodes() {
		Iterator<Node> iterator = allNodes.iterator();
		
		while(iterator.hasNext()) {
			Node current = iterator.next();
			System.out.println(current.key + " : " + current.weight);
		}
	}
}
