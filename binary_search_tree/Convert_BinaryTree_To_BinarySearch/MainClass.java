/*
 1. Given a Binary Tree, convert it to a Binary Search Tree. The conversion must be done in such a way that 
 	keeps the original structure of Binary Tree.

	Examples.
	
	Example 1
	Input:
	          10
	         /  \
	        2    7
	       / \
	      8   4
	Output:
	          8
	         /  \
	        4    10
	       / \
	      2   7
	
	
	Example 2
	Input:
	          10
	         /  \
	        30   15
	       /      \
	      20       5
	Output:
	          15
	         /  \
	       10    20
	       /      \
	      5        30
 
 2.	Similar problem 
  	Convert BST to Min Heap (difference would be in solution no need to sort the array. Just think about it :))

	Given a binary search tree which is also a complete binary tree. The problem is to convert the given BST 
	into a Min Heap with the condition that all the values in the left subtree of a node should be less than 
	all the values in the right subtree of the node. This condition is applied on all the nodes in the so 
	converted Min Heap.
	
	Examples:
	
	Input :          4
	               /   \
	              2     6
	            /  \   /  \
	           1   3  5    7  
	
	Output :        1
	              /   \
	             2     5
	           /  \   /  \
	          3   4  6    7 
	
 */


package Convert_BinaryTree_To_BinarySearch;

public class MainClass {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(30);
		root.right = new Node(15);
		
		root.left.left = new Node(20);
		root.right.right = new Node(5);
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.convertBST(root);
	}
}
