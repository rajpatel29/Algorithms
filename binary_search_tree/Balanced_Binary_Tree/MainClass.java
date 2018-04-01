package Balanced_Binary_Tree;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(45);
		root.left = new Node(31);
		root.right = new Node(91);
		
		root.left.left = new Node(29);
		root.left.left.left = new Node(15);
		
		BinaryTree binaryTree = new BinaryTree();
		System.out.println("Is BST balanced? " + binaryTree.isBalanced(root));
	}
}
