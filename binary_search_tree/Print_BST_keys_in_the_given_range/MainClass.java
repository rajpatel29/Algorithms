package Print_BST_keys_in_the_given_range;

public class MainClass {

	public static void main(String[] args) {
		int k1 = 10, k2 = 25;
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.print(root, k1, k2);
	}

}
