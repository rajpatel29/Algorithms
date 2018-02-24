package Largest_BST_subtree_in_Binary_Tree;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(60);
		
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		
		root.right.left = new Node(45);
		root.right.right = new Node(70);
		
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);
		
		//convert BST to linked list
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.largestBST(root);
		System.out.println(BinaryTree.max);
	}
}
