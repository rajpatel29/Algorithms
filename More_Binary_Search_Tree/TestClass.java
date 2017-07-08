package More_Binary_Search_Tree;

import java.util.Stack;

public class TestClass 
{
	public static int predecessor = 0;
	public static int successor = 0;
	
	public static void main(String[] args) 
	{
		
		//7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10
		
		BinaryTree tree = new BinaryTree(50);
		
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		inorderPredecesorAndSuccessor(tree.getRoot() , 50 );
		System.out.println(predecessor);
		System.out.println(successor);
	}

	
	
	public static void inorderPredecesorAndSuccessor(Node root, int k)
	{
		if(root == null)
			return;
		
		if(root.data == k)
		{
			//successor
			if(root.right == null)
			{
				return;
			}
			else
			{
				findSuccessor(root.right);
			}
			
			//predecessor
			if(root.left == null)
			{
				return;
			}
			else
			{
				findPredecessor(root.left);
			}
		}
		else if(root.data < k)
		{
			predecessor = root.data;
			inorderPredecesorAndSuccessor(root.right , k);
		}
		else if (root.data > k)
		{
			successor = root.data;
			inorderPredecesorAndSuccessor(root.left , k);
		}
	}
	
	private static void findSuccessor(Node right) 
	{
		if(right.left == null)
		{
			successor = right.data;
			return;
		}
		
		findSuccessor(right.left);
	}
	
	private static void findPredecessor(Node left) 
	{
		if(left.right == null)
		{
			predecessor = left.data;
			return;
		}
		
		findPredecessor(left.right);
	}



	public static int inOrderSuccessor(Node root, int k)
	{
		int answer = 0;
		
		if(root == null)
			return 0;
		
		Node pointer = root;
		
		if(root.data == k)
		{
			if(root.right != null)
				return root.right.data;
			else
				return answer;
		}
		
		while(pointer != null)
		{
			if(pointer.data < k)
			{
				System.out.println("right");
				if(pointer.right != null && pointer.right.data == k)
				{
					if(pointer.right.right == null)
					{
						return 0;
					}
					else
					{
						return pointer.right.right.data;
					}
				}
				pointer = pointer.right;
			}
			else if(pointer.data > k)
			{
				System.out.println("left");
				if(pointer.left != null && pointer.left.data == k)
				{
					if(pointer.left.right == null)
					{
						return pointer.data;
					}
					else
					{
						return helperInOrderSuccessor(pointer.left.right);
					}
				}
				pointer = pointer.right;
			}
			
		}
		
		return answer;
	}
	
	private static int helperInOrderSuccessor(Node root) 
	{
		if(root.left == null)
			return root.data;
		
		return helperInOrderSuccessor(root.left);
	}
	
	public static void inOrderUsingStack(Node root, int k )
	{
		
		Stack<Node> stack = new Stack<>();
		
		Node pointer = root;
		
		while(pointer != null || !stack.isEmpty())
		{
			if(pointer != null)
			{
				stack.push(pointer);
				pointer = pointer.left;
			}
			else
			{
				Node current = stack.pop();
				System.out.println(current.data);
				pointer = current.right;
			}
		}
		
	}
}


