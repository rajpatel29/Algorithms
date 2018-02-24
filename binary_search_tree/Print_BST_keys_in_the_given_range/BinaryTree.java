package Print_BST_keys_in_the_given_range;

public class BinaryTree {
	public void print(Node root, int k1, int k2) {
		if(root == null)
			return;
		
		if(k1 < root.data)
			print(root.left, k1, k2);
		
		if(k1 < root.data && root.data < k2)
			System.out.println(root.data);
		
		if(root.data < k2)
			print(root.right, k1, k2);
	}
}
