package Binary_Tree_Implementation;

public class BinaryTree 
{
	private Node root = null;
	public BinaryTree(int data)
	{
		root = new Node(data);
	}
	
	public void insert(int data)
	{
		if(root == null)
		{
			Node newNode = new Node(data);
			root = newNode;
		}
		else
		{
			Node pointer  = root;
			boolean found = true;
			
			while(found)
			{
				if(pointer.data < data)
				{
					if(pointer.right == null)
					{
						Node newNode = new Node(data);
						pointer.right = newNode;
						found = false;
					}
					else
					{
						pointer = pointer.right;
					}
				}
				else
				{
					if(pointer.left == null)
					{
						Node newNode = new Node(data);
						pointer.left = newNode;
						found = false;
					}
					else
					{
						pointer = pointer.left;
					}
				}
			}
		}
	}

	public Node search(int data)
	{
		if(root == null)
			throw new RuntimeException( "Binary Tree is empty");
		
		Node pointer = root;
		
		while(pointer != null)
		{
			if(pointer.data == data)
			{
				return pointer;
			}
			else if(pointer.data < data)
			{
				pointer = pointer.right;
			}
			else
			{
				pointer = pointer.left;
			}
		}
		
		return null;
	}
	
	
	public void delete(int data)
	{
		deleteHelper(root, data);
	}
	
	public Node deleteHelper(Node tree , int data)
	{
		if(tree == null)
			return null;
		
		if(tree.data < data)
		{
			tree.right = deleteHelper(tree.right , data);
		}
		else if(tree.data > data)
		{
			tree.left = deleteHelper(tree.left , data);
		}
		else
		{
			if(tree.left == null && tree.right == null)
			{
				return null;
			}
			else if(tree.left != null && tree.right != null)
			{
				Node smallest = findSmallestInRight(tree.right);
				
				tree.data = smallest.data;
				
				tree.right = deleteHelper(tree.right , smallest.data );
			}
			else
			{
				if(tree.left != null)
				{
					return tree.left;
				}
				else if(tree.right != null)
				{
					return tree.right;
				}
			}
		}
		
		return tree;
	}
	
	
//		Node pointer = root;
//		
//		if(pointer.data == data)
//		{
//			if(pointer.left == null && pointer.right == null)
//			{
//				pointer = null;
//			}
//			else if (pointer.left != null && pointer.right != null)
//			{
//				Node smallest = findSmallestInRight(pointer.right);
//				
//				pointer =smallest;
//				
//				smallest = null;
//			}
//			else
//			{
//				if(pointer.left != null)
//				{
//					pointer = pointer.left;
//				}
//				else if(pointer.right != null)
//				{
//					pointer = pointer.right;
//				}
//			}
//		}
//	}
	
	private Node findSmallestInRight(Node tree) 
	{
		if(tree.left == null)
			return tree;
		
		return findSmallestInRight(tree.left);
	}

	public Node getRoot()
	{
		return root;
	}
	
}
