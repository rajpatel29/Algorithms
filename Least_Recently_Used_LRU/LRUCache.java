package Least_Recently_Used_LRU;

import java.util.HashMap;

public class LRUCache {
	private int cap;
	private Node first, last;
	private HashMap<Integer, Integer> valueMap;
	private HashMap<Integer, Node> recentMap;
	
	public LRUCache (int cap) {
		this.cap = cap;
		valueMap = new HashMap<>();
		recentMap = new HashMap<>();
	}
	
	public void put(int key, int value) {
		if(valueMap.containsKey(key)) {
			valueMap.put(key, value);
		} else {
			if(valueMap.size() == cap) {
				deleteElement();
				valueMap.put(key, value);
			} else {
				valueMap.put(key, value);
			}
		}
		rearrange(key);
	}

	private void rearrange(int key) {
		if(recentMap.containsKey(key)) {	
			Node currentNode = recentMap.get(key);
			if(currentNode.prev == null) {
				if(currentNode.next == null) {
					first = last = currentNode;
					
				} else {
					last = currentNode.next;
					currentNode.next.prev = null;
					currentNode.next = null;
					
					first.next = currentNode;
					currentNode.prev = first;
					
					first = currentNode;
				}
			} else {
				if(currentNode.next == null) {
					first = currentNode;
				} else {
					Node previousNode = currentNode.prev;
					Node nextNode = currentNode.next;
					
					previousNode.next = nextNode;
					nextNode.prev = previousNode;
					
					currentNode.prev = first;
					first.next = currentNode;
					currentNode.next = null;					
					first = currentNode;
				}
			}
		} else {
			Node newNode = new Node(key);
			if(first == null) {
				first = last = newNode;
			} else {
				first.next = newNode;
				newNode.prev =  first;
			
				first = newNode;
			}
		}
		
		recentMap.put(key, first);
	}
	
	private void deleteElement() {
		if(last == null)
			return;
		
		Node temp = last;
		valueMap.remove(temp.key);
		recentMap.remove(temp.key);
		if(last.next == null) {
			first = last = null;
		} else {
			last = last.next;
			last.prev = null;
		}
	}
	
	
	public int get(int key) {
		if(valueMap.containsKey(key)) {
			rearrange(key);
			return valueMap.get(key);
		} 
		
		return -1;
	}
	
	
	
	
	
	
	public void show() {
		System.out.println("Elements are : ");
		Node pointer = last;
		
		while(pointer != null) {
			System.out.println(pointer.key);
			pointer = pointer.next;
		}
		System.out.println("First: " + first.key + "   Last : " + last.key);
		System.out.println("----------");
		System.out.println();
	}
	
	
	
}
