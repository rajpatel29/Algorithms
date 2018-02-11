/*
Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50
*/

package Construct_BST_from_Preorder_Traversal;

public class MainClass {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
        
		int input[] = new int[]{10, 5, 1, 7, 11, 30, 40, 50};
        Node root = binaryTree.constructBST(input);
        
        System.out.println("Inorder traversal of the constructed tree is ");
        binaryTree.printInorder(root);
	}
}
