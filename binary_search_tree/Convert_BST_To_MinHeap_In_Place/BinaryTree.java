package Convert_BST_To_MinHeap_In_Place;

public class BinaryTree {
	Node firstNodeLinkedList = null;
	
	public void convertBST(Node root) {
		// reverse inorder traversal and make a linked list from BST
		reverseInorderTravesal(root);
		
		//convert linked list to min hip
		Node result = linkedListToMinHeap();
		
		inorderTravesal(result);
		
	}
	
	public void reverseInorderTravesal(Node root) {
		if(root == null)
			return;
		
		if(root.right != null)
			reverseInorderTravesal(root.right);
		
		root.right = firstNodeLinkedList;
		firstNodeLinkedList = root;
		
		if(root.left != null)
			reverseInorderTravesal(root.left);
	}
	
	public void inorderTravesal(Node root) {
		if(root == null)
			return;
		
		if(root.left != null)
			inorderTravesal(root.left);
		
		System.out.println(root.data);
		
		if(root.right != null)
			inorderTravesal(root.right);	
	}
	
	public Node linkedListToMinHeap() {
		Node pointer = firstNodeLinkedList;
		if(pointer == null || pointer.right == null) {
			return pointer;
		}
		
		Node fastPointer = firstNodeLinkedList.right;
		
		Node next = null;
		while(pointer != null && fastPointer != null) {
			next = pointer.right;
			pointer.left = fastPointer;
			fastPointer = fastPointer.right;
			
			if(fastPointer == null) {
				pointer.right = null;
				break;
			}
			pointer.right = fastPointer;
		
			pointer = next;
			fastPointer = fastPointer.right;
		}
		
		while(next != null){
			Node temp = next.right;
			next.right = null;
			next.left = null;
			next = temp;
		}
		
		return firstNodeLinkedList;
	}
	
	public void printLinkedList() {
		Node root = firstNodeLinkedList;
		while(root != null) {
			System.out.println(root.data);
			root = root.right;
		}
	}
}
