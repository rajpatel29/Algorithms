package Construct_BST_from_Preorder_Traversal;

public class BinaryTree {
	
	int currentIndex = 0;
	
	public Node constructBST(int[] input) {
		Node result = null;
	
		if(input.length == 0)
			return null;
		
		return constructBSTHelper(input, input.length, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	private Node constructBSTHelper(int[] input, int arrayLength, int maxValue, int minValue) {
		
		if (currentIndex >= arrayLength)
			return null;
		
		if(maxValue < input[currentIndex] || input[currentIndex] < minValue)
			return null;
					
		Node newNode = new Node(input[currentIndex]);
		currentIndex++;
		
		newNode.left = constructBSTHelper(input, arrayLength, input[currentIndex-1], minValue);
		
		newNode.right = constructBSTHelper(input, arrayLength, maxValue, input[currentIndex-1]);
		
		return newNode;
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
