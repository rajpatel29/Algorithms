/*
	Similar problem
	Check if a Singly Linked List is Palindrome
*/

package MiddleOfLinkedList;

public class LinkedList {
	private Node lastNode = null;
	private Node firstNode = null;
	
	private class Node {
		int data;
		Node next;
		
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public void push(int data) {
		Node node = new Node(data);
		if(lastNode == null) {
			lastNode = node;
			firstNode = node;
		} else {
			lastNode.next = node;
			lastNode = node;
		}
	}
	
	public int findMiddle() {
		if(firstNode == null) {
			return -1;
		} 
				
		Node fastPointer = firstNode;
		Node slowPointer = firstNode;
		
		
		while (fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		return slowPointer.data;
	}
	
	public void printAllNodes() {
		Node current = firstNode;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
}
