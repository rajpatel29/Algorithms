package Balanced_Binary_Tree;

public class BinaryTree {
	 public boolean isBal = true;
	    public boolean isBalanced(Node root) {
	        heightOfTheTree(root);
	        return isBal;
	    }
	    
	    public int heightOfTheTree(Node root) {
	        if(root == null)
	            return 0;
	        
	        if(root.right == null && root.left == null)
	            return 1;
	        
	        int rightHeight = heightOfTheTree(root.right);
	        int leftHeight = heightOfTheTree(root.left);
	        
	        if(Math.abs(rightHeight-leftHeight) >= 2) {
	            isBal = false;
	            return 0;   
	        }
	        
	        return 1 + Math.max(rightHeight, leftHeight);
	    }
	}