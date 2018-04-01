package MorrisTraversal;

import Constructing_Binary_tree.Node;

public class BinaryTree {
	
	public void morrisTraversal() {
		morrisTraversalRec(firstNode);
	}

	private void morrisTraversalRec(Node root) {
		if(root == null)
			return;
		
		if(root.left == null) {
			System.out.println(root.data);
			morrisTraversalRec(root.right);
		} else {
			Node temp = root.left;
			boolean visited = false;
			while(temp.right != null) {
				if(temp.data == root.data) {
					visited = true;
					break;
				}
				temp = temp.right;
			}
			
			if(visited) {
				System.out.println(root.data);
				morrisTraversalRec(root.right);
			} else {
				temp.right = root;
				morrisTraversalRec(root.left);
			}
		}
	}
	
	// Binary tree insert
	private Node firstNode = null;
	
	public void insert(int newValue) {
		Node newNode = new Node(newValue);
		if(firstNode == null) {
			firstNode = newNode;
			return;
		}
		
		Node pointer = firstNode;
		while(true) {
			if(pointer.data > newValue) {
				if(pointer.left == null) {
					pointer.left = newNode;
					return;
				}
				pointer = pointer.left;
			} else {
				if(pointer.right == null) {
					pointer.right = newNode;
					return;
				}
				pointer = pointer.right;
			}
		}
	}
}
