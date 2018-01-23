package CancelSubSequencesSum0;

import javax.management.DynamicMBean;

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

	public void printAllNodes() {
		Node current = firstNode;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void cancelOutSum0() {
		Node dummy = new Node(0);
		Node firstPointer = dummy;
		dummy.next = firstNode;
		Node start = firstNode;
		Node end = firstNode;

		if(start == null || start.next == null)
			return ;

		while(start != null) {
			int sum = 0;
			boolean isSum0 = false;
			while(end !=null) {
				sum += end.data;
				if(sum == 0) {
					isSum0 = true;
					sum = 0;
					break;
				}
				end = end.next;
			}

			if(isSum0) {
				start = end.next;
				if(start == null) {
					dummy.next = null;
				}
			} else {
				System.out.println("in ");
				dummy.next = start;
				dummy = start;
				start = start.next;
			}
			end = start;
		}

		Node current = firstPointer.next;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}
