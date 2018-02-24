package Constructing_Binary_tree;

public class BinaryTree {
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
	
	public void delete(int value) {
		firstNode = deleteRec(firstNode, value);
	}
	
	public Node deleteRec(Node root, int value) {
		if(root == null)
			return null;
		
		if(root.data < value) {
			root.right = deleteRec(root.right, value);
		} else if(root.data > value){ 
			root.left = deleteRec(root.left, value);
		} else {
			if(root.left == null && root.right == null) {
				return null;
			} else if(root.left == null) {
				int min = returnMin(root.right);
				root.data = min;
				root.right = deleteRec(root.right, min);
			} else if (root.right == null) {
				int max = returnMax(root.left);
				root.data = max;
				root.left = deleteRec(root.left, max);
			} else {
				int max = returnMax(root.left);
				root.data = max;
				root.left = deleteRec(root.left, max);
			}
		}
		
		return root;
	}
	
	public int returnMin(Node root) {
		int min = Integer.MAX_VALUE;
		while(root != null) {
			min = Math.min(root.data, min);
			root = root.left;
		}
		
		return min;
	}
	
	public int returnMax(Node root) {
		int max = Integer.MIN_VALUE;
		while(root != null) {
			max = Math.max(root.data, max);
			root = root.right;
		}
		
		return max;
	}
	
	public boolean search(int value) {
		Node pointer = firstNode;
		
		while(pointer != null) {
			if(pointer.data == value) {
				return true;
			} else if (pointer.data > value) {
				pointer = pointer.left;
			} else {
				pointer = pointer.right;
			}
		}
		
		return false;
	}
	
	public void printInOrder() { 
		System.out.println("In order traversal of the given tree is:");
		inOrder(firstNode);
	}
	
	private void inOrder(Node root) {
		if(root == null)
			return;
		
		inOrder(root.left);
		
		System.out.println(root.data);
		
		inOrder(root.right);
	}
}
