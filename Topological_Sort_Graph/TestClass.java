package Topological_Sort_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TestClass 
{
	public static void main(String[] args) 
	{
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		
		nodeA.getChild().add(nodeC);
		nodeB.getChild().add(nodeC);
		nodeB.getChild().add(nodeD);
		nodeC.getChild().add(nodeE);
		nodeD.getChild().add(nodeF);
		nodeE.getChild().add(nodeH);
		nodeE.getChild().add(nodeF);
		nodeF.getChild().add(nodeG);
		
		ArrayList<Node> nodes = new ArrayList<>();
		nodes.add(nodeA);
		nodes.add(nodeB);
		nodes.add(nodeC);
		nodes.add(nodeD);
		nodes.add(nodeE);
		nodes.add(nodeF);
		nodes.add(nodeG);
		nodes.add(nodeH);
		
		topologicalSearch(nodes);
	}

	private static void topologicalSearch(ArrayList<Node> nodes) 
	{
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<>();
		
		while(!nodes.isEmpty())
		{
			Node current = nodes.remove(0);
//			System.out.println("Out: " + current.getData());
			helperMethod(current , nodes, stack,visited);
		}
		
		int size = stack.size();
		for(int  i = 0 ; i < size ; i++)
		{
			System.out.println(stack.pop().getData());
		}
	}

	private static void helperMethod(Node current, ArrayList<Node> nodes, Stack<Node> stack, Set<Node> visited) 
	{
		if(current.getChild().isEmpty())
		{
			visited.add(current);
			nodes.remove(current);
			stack.add(current);
			return;
		}
		
		visited.add(current);
		nodes.remove(current);
		for(Node child : current.getChild() )
		{
			if(!visited.contains(child))
				helperMethod(child , nodes, stack,visited);
		}
		stack.add(current);
	}
	
	
	
	
	
	
}
