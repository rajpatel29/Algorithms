package Convert_BinaryTree_To_BinarySearch;

import java.util.Collections;
import java.util.LinkedList;

public class BinaryTree {
	
	int currentIndex = 0;
	LinkedList<Integer> elements = new LinkedList<Integer>();
	
	public void convertBST(Node root) {
		insertElementsInPreorder(root);
		
		Collections.sort(elements);
		
		replaceInorder(root);

		printInorder(root);
	}
	
	public void insertElementsInPreorder(Node root) {
		if(root == null)
			return;
		
		elements.add(root.data);
		
		if(root.left != null)
			insertElementsInPreorder(root.left);
		
		if(root.right != null)
			insertElementsInPreorder(root.right);
	}
	
	public void replaceInorder(Node root) {
		if(root == null)
			return;
		
		if(root.left != null)
			replaceInorder(root.left);

		root.data = (int) elements.get(currentIndex);
		currentIndex++;
		
		if(root.right != null)
			replaceInorder(root.right);
	}
	
	public void printInorder(Node root) {
		if(root == null)
			return;
		
		if(root.left != null)
			printInorder(root.left);

		System.out.println(root.data);
		
		if(root.right != null)
			printInorder(root.right);
	}
}
