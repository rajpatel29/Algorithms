package Topological_Sort_Graph;

import java.util.ArrayList;

public class Node
{
	private String data;
	private ArrayList<Node> childs;
	
	public Node(String data)
	{
		this.data = data;
		this.childs = new ArrayList<>();
	}
	
	public void addChild(Node child)
	{
		this.childs.add(child);
	}
	
	//all the getter
	public ArrayList<Node> getChild()
	{
		return this.childs;
	}
	
	public String getData()
	{
		return this.data;
	}
}
