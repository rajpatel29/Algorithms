package Binary_Tree_Implementation;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestClass 
{
	public static void main(String[] args) 
	{
		
		//7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10
		
		BinaryTree tree = new BinaryTree(7);
		
		tree.insert(1);
		tree.insert(0);
		tree.insert(3);
		tree.insert(2);
		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(9);
		tree.insert(8);
		tree.insert(10);
	
		morrisInorderTraversal(tree.getRoot());
		System.out.println();
		System.out.println();
		inOrder(tree.getRoot());
	}
	
	
	public static void morrisInorderTraversal(Node root)
	{
		Node current = root;
		
		while(current != null)
		{
			if(current.left == null)
			{
				System.out.println(current.data);
				current = current.right;
			}
			else
			{
				Node pre = current.left;
				 /* Find the inorder predecessor of current */
				while(pre.right != null && pre.right != current)
				{
					pre = pre.right;
				}
				
				/* Make current as right child of its inorder predecessor */
				if(pre.right == null)
				{
					pre.right = current;
					current = current.left;
				}
				/* Revert the changes made in if part to restore the 
                original tree i.e.,fix the right child of predecssor*/
				else
				{
					pre.right = null;
					System.out.println(current.data);
					current = current.right;
				}
				
			}
			
		}
	}
	
	
	
	
	public static void printAllPath(Node root)
	{
		printPathHelper(root, "");
	}
	
	public static void printPathHelper(Node root, String parentPath)
	{
		if(root == null)
			return;
		
		String  path = parentPath + "/" + root.data;
		System.out.println("Node " + root.data + " : " +  path);
		
		if(root.left != null)
		{
			printPathHelper(root.left , path);
		}
		
		if(root.right != null)
		{
			printPathHelper(root.right , path);
		}
	}
	
	public static void dfsTravesal(Node root)
	{
		ArrayList<Node> list = new ArrayList<>();
		list.add(root);
		
		int listSize = list.size();
		while(!list.isEmpty())
		{
			for(int  i = 0 ; i < listSize ; i++)
			{
				Node current = list.remove(0);
				
				if(current.left != null)
					list.add(current.left);
				
				if(current.right != null)
					list.add(current.right);
				
				System.out.print(current.data + " ");
			}
		}
	}
	
	public static void spiralTravesal(Node root)
	{
		if(root  == null)
			return;
		
		boolean spiral = true;
		LinkedList<Node> list = new LinkedList<>();
		list.add(root);
		
		int listSize = 0;
		while(!list.isEmpty())
		{
			listSize = list.size();
			if(spiral)
			{
				for(int  i = 0 ; i < listSize ; i++)
				{
					Node current = list.remove(listSize-1-i);
					
					if(current.left != null)
						list.addLast(current.left);
					
					if(current.right != null)
						list.addLast(current.right);
					
					System.out.print(current.data + " ");
				}
			}
			else
			{
				for(int  i = 0 ; i < listSize ; i++)
				{
					Node current = list.removeFirst();
					
					if(current.left != null)
						list.addLast(current.left);
					
					if(current.right != null)
						list.addLast(current.right);
					
					System.out.print(current.data + " ");
				}
			}
			spiral = !spiral;
			
		}
	}
	
	
	public static void inOrder(Node root)
	{
		if(root == null)
			return;
		
		if(root.left != null)
			inOrder(root.left);
		
		System.out.println(root.data);
		
		if(root.right != null)
			inOrder(root.right);
	}
	
	public static void preOrder(Node root)
	{
		if(root == null)
			return;
		
		System.out.println(root.data);
		
		if(root.left != null)
			preOrder(root.left);
		
		if(root.right != null)
			preOrder(root.right);
	}
	
	public static void postOrder(Node root)
	{
		if(root == null)
			return;
		
		if(root.left != null)
			postOrder(root.left);
		
		if(root.right != null)
			postOrder(root.right);
		
		System.out.println(root.data);
	}
}
