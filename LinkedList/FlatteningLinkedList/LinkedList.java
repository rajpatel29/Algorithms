package FlatteningLinkedList;

public class LinkedList {
	public Node lastNode = null;
	public Node firstNode = null;
	
	public class Node {
		int data;
		Node next;
		LinkedList childs;
		
		public Node(int d, LinkedList childs) {
			this.data = d;
			this.next = null;
			this.childs = childs;
		}
	}
	
	public void push(int data, LinkedList childs) {
		Node node = new Node(data, childs);
		if(lastNode == null) {
			lastNode = node;
			firstNode = node;
		} else {
			lastNode.next = node;
			lastNode = node;
		}
	}
	
	public LinkedList flattenList() {
		Node sortedFirst = null;
		Node currentHead = firstNode;
		LinkedList result = new LinkedList();
		
		while(currentHead != null) {
			result.push(currentHead.data, null);
			
			Node childrenPointer = currentHead.childs.firstNode;
			while(childrenPointer != null) {
				if (currentHead.next == null) {
				
					if(sortedFirst == null) {
						result.push(childrenPointer.data, null);
					} else {
						while(sortedFirst != null && sortedFirst.data <= childrenPointer.data) {
							result.push(sortedFirst.data, null);
							sortedFirst = sortedFirst.next; 
						}
						result.push(childrenPointer.data, null);
					}
					
				} else if(childrenPointer.data <= currentHead.next.data) {
					if(sortedFirst == null) {
						result.push(childrenPointer.data, null);
					} else {
						while(sortedFirst != null && sortedFirst.data <= childrenPointer.data) {
							result.push(sortedFirst.data, null);
							sortedFirst = sortedFirst.next; 
						}
						result.push(childrenPointer.data, null);
					}
				} else {
					sortedFirst = insertInsSortedOrder(sortedFirst, childrenPointer.data);
				}
				childrenPointer = childrenPointer.next;
			}
			
			currentHead = currentHead.next;
		}
		
		while(sortedFirst != null) {
			result.push(sortedFirst.data, null);
			sortedFirst = sortedFirst.next; 
		}
		
		return result;
	}
	
	
	public Node insertInsSortedOrder(Node s, int data) {
		Node firstNode = s;
		Node newNode = new Node(data, null);
		if(s == null || s.data >= data) {
			firstNode = newNode;
			firstNode.next = s;
		} else {
			Node current = s;
			while(current.next != null && current.next.data < data) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		
		return firstNode;
	} 
	
	public static void printAll(Node n) {
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
}
