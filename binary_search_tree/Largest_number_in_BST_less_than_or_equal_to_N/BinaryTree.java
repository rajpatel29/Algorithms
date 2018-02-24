package Largest_number_in_BST_less_than_or_equal_to_N;

public class BinaryTree {
	Node firstNodeLinkedList = null;
	int largestNumber = Integer.MIN_VALUE;
	
	public void largestNumberBST(Node root, int N) {
		largestNumberBSTHelper(root, N);
		System.out.println("Largest number is " + largestNumber);
	}
	
	public void largestNumberBSTHelper(Node root, int N) {
		if(root == null)
			return;
		
		if(root.data <= N) {
			largestNumber = root.data;
			largestNumberBSTHelper(root.right, N);
		} else {
			largestNumberBSTHelper(root.left, N);
		}
	}
}
