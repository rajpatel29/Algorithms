package Constructing_Binary_tree;

public class MainClass {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.insert(45);
		binaryTree.insert(31);
		binaryTree.insert(91);
		binaryTree.insert(29);
		binaryTree.insert(15);
		binaryTree.insert(14);
		binaryTree.insert(19);
		binaryTree.insert(27);
		binaryTree.insert(37);
		binaryTree.insert(87);
		binaryTree.insert(105);
	
		binaryTree.insert(33);
		binaryTree.insert(44);
		binaryTree.insert(67);
		
//		binaryTree.delete(30);
//		binaryTree.delete(33);
//		binaryTree.delete(87);
//		binaryTree.delete(29);
//		binaryTree.delete(45);
//		binaryTree.delete(29);
//				
		binaryTree.printInOrder();
	}
}
