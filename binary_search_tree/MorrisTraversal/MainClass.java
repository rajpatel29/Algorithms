// In order Tree Traversal without recursion and without stack!

package MorrisTraversal;

public class MainClass {
	public static void main(String[] args) {
			
		//convert BST to linked list
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(60);
		binaryTree.insert(5);
		binaryTree.insert(20);
		binaryTree.insert(45);
		binaryTree.insert(70);
		binaryTree.insert(65);
		binaryTree.insert(80);
		
		binaryTree.insert(67);
		binaryTree.insert(12);
		binaryTree.insert(2);
		binaryTree.insert(102);
		
		binaryTree.morrisTraversal();
	}
}
