package Implement_Tree_and_DFS;

import java.util.ArrayList;

public class Node
{
	private int data;
	private ArrayList<Node> childs;
	private Node parent;
	
	public Node(int data, Node parent)
	{
		this.data = data;
		this.childs = new ArrayList<>();
		this.parent = parent;
		parent.getChild().add(this);
	}
	
	public Node(int data)
	{
		this.data = data;
		this.childs = new ArrayList<>();
	}
	
	public void addChild(Node child)
	{
		this.childs.add(child);
		child.parent = this;
	}
	
	//all the getter
	public ArrayList<Node> getChild()
	{
		return this.childs;
	}
	
	public int getData()
	{
		return this.data;
	}
	
	public Node getParent()
	{
		return this.parent;
	}
	
}
