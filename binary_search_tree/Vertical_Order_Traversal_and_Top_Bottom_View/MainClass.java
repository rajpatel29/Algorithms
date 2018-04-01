/*
 	Similar Problems
 	
 		1	Top View of BST
 		2	Bottom View of BST
 */

package Vertical_Order_Traversal_and_Top_Bottom_View;

public class MainClass {
	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();

		Node root = new Node(1);	
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);

		bst.verticalTraversal(root);
	}
}
