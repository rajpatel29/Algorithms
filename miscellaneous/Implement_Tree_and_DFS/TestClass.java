package Implement_Tree_and_DFS;

import java.util.ArrayList;
import java.util.Stack;

public class TestClass 
{
	public static void main(String[] args) 
	{
		Node root = new Node(0 );
		
		Node child1 = new Node(1);
		Node child2 = new Node(2);
		root.addChild(child1);
		root.addChild(child2);
		Node child11 = new Node(3 , child1);
		Node child12 = new Node(4 , child1);
		
		Node child111 = new Node(9 , child11);

		Node child21 = new Node(5 , child2);
		Node child22 = new Node(6 , child2);
		
		getDFS(root);
	}
	
	public static void getDFS(Node root)
	{
		if(root  ==  null)
			return;
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			Node current = stack.pop();
			System.out.println(current.getData());
			ArrayList<Node> allChilds = current.getChild();
			
			for(int i = allChilds.size() - 1; i >= 0 ; i--)
			{
				stack.add(allChilds.get(i));
			}
			
		}
		
	}
}
