package Diameter_of_Binary_Tree;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(12);
		
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		
		root.right.left = new Node(11);
		root.right.right = new Node(14);
		
		//convert BST to linked list
		BinaryTree binaryTree = new BinaryTree();
		int diameter = binaryTree.diameterOfBinaryTree(root);
		System.out.println(diameter);
		
	}
}
