package Largest_BST_subtree_in_Binary_Tree;

public class BinaryTree {
	public static int max = 1;
			
	public int largestBST(Node root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		int leftResult = largestBST(root.left);
		int rightResult = largestBST(root.right);
		
		int result = 1;
		if(leftResult == 0) {
			if (root.data < root.right.data) {
				result = 1 + rightResult;
			}
		} else if (rightResult == 0) {
			if (root.left.data < root.data) {
				result = 1 + leftResult;
			}
		}  else {
			if (root.data < root.right.data && root.left.data < root.data) {
				result = 1 + leftResult + rightResult;
			}
		}
		System.out.println("root data " + root.data + "    result "  + result);
		max = Math.max(max, result);
		return result;
	}
}
