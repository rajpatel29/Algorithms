package Kruskals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DisjointSet {
	Node[] nodes;
	HashMap<Integer, Node> hashMap = new HashMap();
	
	public DisjointSet(int noOfNode) {
		nodes = new Node[noOfNode];
	
	}
	
	public class Node {
		int rank;
		int data;
		Node parent;
	}

	public void makeSet(int data) {
		Node node = new Node();
		node.rank = 0;
		node.data = data;
		node.parent = node;
		hashMap.put(data, node);
	} 
	
	public void union(int n1, int n2) {
		Node representative1 = findSet(n1);
		Node representative2 = findSet(n2);
		
		if(representative1.data != representative2.data) {
			if(representative1.rank > representative2.rank) {
				representative2.rank = 0;
				representative2.parent = representative1;
			} else if(representative1.rank < representative2.rank) {
				representative1.rank = 0;
				representative1.parent = representative2;	
			} else {
				representative1.rank = representative1.rank + 1;
				representative2.rank = 0;
				representative2.parent = representative1;
			}
		} else {
			//already union
		}
	}
	
	public Node findSet(int data) {
		Node node = hashMap.get(data);
		
		Node previous = node;
		Node current = node.parent;
		
		while(previous.data != current.data) {
			previous =  current;
			current = current.parent;
		}
		
		return current;
	}
	
	public void printMe() {
		Iterator iterator = hashMap.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry pair = (Map.Entry)iterator.next();
			Node node = (Node)pair.getValue();
			System.out.println(pair.getKey() + " : "+ node.parent.data);
		}
				
	}
}
