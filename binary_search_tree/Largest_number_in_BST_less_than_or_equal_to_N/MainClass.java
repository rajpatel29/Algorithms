package Largest_number_in_BST_less_than_or_equal_to_N;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(12);
		
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		root.right.left = new Node(9);
		root.right.right = new Node(21);
		
		root.right.right.left = new Node(19);
		root.right.right.right = new Node(25);
		
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.largestNumberBST(root, 34);
	}
}
