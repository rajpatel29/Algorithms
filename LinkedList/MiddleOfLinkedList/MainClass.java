package MiddleOfLinkedList;

public class MainClass {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(1);
		list.printAllNodes();
		System.out.println("Middle element is " + list.findMiddle());
		
		list.push(2);
		list.printAllNodes();
		System.out.println("Middle element is " + list.findMiddle());
		
		list.push(3);
		list.printAllNodes();
		System.out.println("Middle element is " + list.findMiddle());
		
		list.push(4);
		list.printAllNodes();
		System.out.println("Middle element is " + list.findMiddle());
		
		list.push(5);
		list.printAllNodes();
		System.out.println("Middle element is " + list.findMiddle());
		
		list.push(6);
		list.printAllNodes();
		System.out.println("Middle element is " + list.findMiddle());
	}
}
