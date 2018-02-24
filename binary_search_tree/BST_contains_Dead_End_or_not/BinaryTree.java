package BST_contains_Dead_End_or_not;

public class BinaryTree {
	public void isDeadEnd(Node root) {
		System.out.println("is dead end " + !isDeadEndHelper(root, 0, Integer.MAX_VALUE));
	}
	
	public boolean isDeadEndHelper(Node root, int minValue, int maxValue) {
		if(root == null) 
			return true;
		
		if(root.left == null && root.right == null) {
			if(minValue == root.data - 1 && maxValue == root.data + 1 ) {
				return false;
			} else {
				return true;
			}
		}
		
		return isDeadEndHelper(root.left, minValue, root.data) && 
				isDeadEndHelper(root.right, root.data, maxValue);
	}
}
