package PrintElementsInReverse;

public class LinkedList {
	private Node lastNode = null;
	private Node firstNode = null;
	
	public class Node {
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

	public void reverse() {
		reverseHelper(firstNode);
	}

	private void reverseHelper(Node head) {
		if(head == null)
			return;
		
		reverseHelper(head.next);
		System.out.println(head.data);
	}	
}
