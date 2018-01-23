package Least_Frequently_Used_LFU;

import java.util.HashMap;

public class LFUCache {
	private Node head = null;
    private int cap = 0;
    private HashMap<Integer, Integer> valueHash = null;
    private HashMap<Integer, Node> nodeHash = null;
    
    public LFUCache(int capacity) {
        this.cap = capacity;
        valueHash = new HashMap<Integer, Integer>();
        nodeHash = new HashMap<Integer, Node>();
    }
	
	public int get(int key) {
		if(valueHash.containsKey(key)) {
			increaseCount(key);
			return (int)valueHash.get(key);
		}
		
		return -1;
	}
	
	private void increaseCount(int key) {
		Node node= nodeHash.get(key);
		node.keys.remove(key);
		
		if(node.next == null) {
			node.next = new Node(node.count+1);
			node.next.keys.add(key);
			node.next.prev = node;
		} else if (node.count + 1 == node.next.count) {
			node.next.keys.add(key);
		} else  {
			Node newNode = new Node(node.count+1);
			newNode.keys.add(key);
			newNode.next = node.next;
			newNode.prev = node;
			node.next.prev = newNode;
			node.next = newNode;
			
							
		}
		
		nodeHash.put(key, node.next);
        if (node.keys.size() == 0) remove(node);
	}
	
	private void remove(Node node) {
		if(node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
        }
	}

	public void put(int key, int value) {
		if(cap == 0) 
			return;
		
		if(valueHash.containsKey(key)) {
			valueHash.put(key, value);	
		} else {
			if (valueHash.size() < cap ) {
				valueHash.put(key, value);
			} else  {
				removeOld();
				valueHash.put(key, value);
			}
			addToHead(key);
		}
		
		increaseCount(key);
	}
	
	private void addToHead(int key) {
		if(head == null) {
			head = new Node(0);
			head.keys.add(key);
		} else if (head.count > 0) {
			Node node = new Node(0);
			node.keys.add(key);
			head.prev = node;
			node.next = head;
			head = node;
		} else {
			head.keys.add(key);
		}
		nodeHash.put(key, head);
	}

	private void removeOld() {
		if (head == null)
			return;
		
		int old = 0;
		for (int counter : head.keys) {
			old = counter;
			break;
		}
		
		head.keys.remove(old);
		if(head.keys.size() == 0 ) remove(head);
		
		valueHash.remove(old);
		nodeHash.remove(old);
	}
}