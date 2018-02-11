/*
 In-place Convert BST into a Min-Heap
	
	Given a Binary Search Tree, convert it into a Min-Heap containing the same elements in O(n) time. 
	Do this in-place.
	
	Input: Binary Search Tree
	        8
	     /    \
	    4      12
	  /  \     /  \
	 2    6   10  14
	
	
	Output - Min Heap
	       2
	     /    \
	   4        6
	 /  \     /   \
	8    10  12   14
	[Or any other tree that follows Min Heap
	 properties and has same keys]
	
	 How to do it in-place?
	The idea is to convert the binary search tree into a sorted linked list first. We can do this by traversing the BST 
	in inorder fashion. We add nodes at the beginning of current linked list and update head of the list using pointer 
	to head pointer. Since we insert at the beginning, to maintain sorted order, we first traverse the right subtree 
	before the left subtree. i.e. do a reverse inorder traversal.
	
	Finally we convert the sorted linked list into a min-Heap by setting the left and right pointers appropriately.
	We can do this by doing a Level order traversal of the partially built Min-Heap Tree using queue and traversing 
	the linked list at the same time. At every step, we take the parent node from queue, make next two nodes of linked 
	list as children of the parent node, and enqueue the next two nodes to queue. As the linked list is sorted, 
	the min-heap property is maintained.
*/


package Convert_BST_To_MinHeap_In_Place;

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
		binaryTree.convertBST(root);
		
	}
}
