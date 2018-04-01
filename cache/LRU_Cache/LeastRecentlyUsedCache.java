package LRU_Cache;

import java.util.HashMap;

public class LeastRecentlyUsedCache {
	private int capacity;
	private int currentNumberOfEntries = 0;
	private Node mostRecentNode, leastRecentNode = null;
	private HashMap<Integer, Node> cacheHashMap = new HashMap<>();
	
	
	public LeastRecentlyUsedCache(int capacity) {
		this.capacity = capacity;
	}
	
	public void put(int key, int value) {
		//	key exists
		if(cacheHashMap.containsKey(key)) {
			// if value is different from stored value
			cacheHashMap.get(key).value = value;	
			reArrange(key);
			return;
		}
		
		// key does not exists
		Node newNode = new Node(key, value);
		cacheHashMap.put(key, newNode);
		
		if(currentNumberOfEntries < capacity) {
			// First element in the cache
			if(currentNumberOfEntries == 0) {
				mostRecentNode = newNode;
				leastRecentNode = newNode;
			} else {
				newNode.prev = mostRecentNode;
				mostRecentNode.next = newNode;
				mostRecentNode = newNode;
			}
			
			currentNumberOfEntries++;
		} else {
			// remove least recent node
			cacheHashMap.remove(leastRecentNode.key);
			
			if(capacity == 1) {
				leastRecentNode = mostRecentNode = newNode;
			} else {
				leastRecentNode = leastRecentNode.next;
				leastRecentNode.prev = null;
				
				newNode.prev = mostRecentNode;
				mostRecentNode.next = newNode;
				mostRecentNode = newNode;
			}	
		}
		
	}
	
	public int get(int key) {
		if(cacheHashMap.containsKey(key)) {
			Node currentNode = cacheHashMap.get(key);
			reArrange(key);
			
			return currentNode.value;
		} else {
			return -1;
		}		
	}
	
	public void reArrange(int key) {
		Node currentNode = cacheHashMap.get(key);
		
		// element is in the first position of Doubly Linked List
		if(currentNode == mostRecentNode) {
			return;
		} else {
			if(currentNode == leastRecentNode) {
				// element is in the last position of Doubly Linked List
				leastRecentNode = leastRecentNode.next;
			} else {
				// element is in the middle of Doubly Linked List
				Node preNode = currentNode.prev;
				Node nextNode = currentNode.next;
				
				preNode.next = nextNode;
				nextNode.prev = preNode;
			}
			
			currentNode.prev = mostRecentNode;
			mostRecentNode.next = currentNode;
			mostRecentNode = currentNode;
		}
	}
	
	private class Node {
		int key, value;
		Node prev, next = null;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;	
		}
	}
}
