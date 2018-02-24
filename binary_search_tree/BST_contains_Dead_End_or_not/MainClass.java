package BST_contains_Dead_End_or_not;

public class MainClass {
	public static void main(String[] args) {
		
//		Example 1
		
//		Node root = new Node(8);
//		root.left = new Node(5);
//		root.right = new Node(11);
//		
//		root.left.left = new Node(2);
//		root.left.right = new Node(7);
//		
//		root.left.left.left = new Node(3);
//		
//		root.left.left.left.left = new Node(4);
		
//		Example 2
		
		Node root = new Node(8);
		root.left = new Node(5);
		root.right = new Node(9);
		
		root.left.left = new Node(2);
		root.left.right = new Node(7);
		
		root.left.left.left = new Node(1);
		
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.isDeadEnd(root);
	}
}
