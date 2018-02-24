/*
	Given an array that stores a complete Binary Search Tree, write a function that efficiently prints the given 
	array in ascending order.

=>	Full binary tree
	A full binary tree (sometimes proper binary tree or 2-tree) is a tree in which every node other than the leaves 
	has two children.

=>	Complete binary tree
	A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and 
	all nodes are as far left as possible. 
*/

package Sorted_order_printing_of_an_array_that_represents_BST;

public class MainClass {
	public static void main(String args[]) {
		 int arr[] = {4, 2, 9, 1, 3, 5,12};
         
	      printSorted(arr, 0, arr.length-1 );
	}

	
	private static void printSorted(int[] arr, int start, int end) {
		if(start > end)
	        return;
	         
	    // print left subtree
	    printSorted(arr, start*2 + 1, end);
	         
	    // print root
	    System.out.println(arr[start]);
	         
	    // print right subtree
	    printSorted(arr, start*2 + 2, end); 
   }
         
}
