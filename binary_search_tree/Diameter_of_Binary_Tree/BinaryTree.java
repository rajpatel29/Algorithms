package Diameter_of_Binary_Tree;

public class BinaryTree {
	
	public int diameterOfBinaryTree(Node root) {
        if(root == null)
            return 0;

        return Math.max((treeHeight(root.right) + treeHeight(root.left)), 
        		Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));   
    }

	public int treeHeight(Node root) {
        if(root == null)
            return 0;
        
        return 1 + Math.max(treeHeight(root.right), treeHeight(root.left));
    }
}
