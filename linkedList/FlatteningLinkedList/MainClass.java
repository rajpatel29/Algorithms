package FlatteningLinkedList;

public class MainClass {
	public static void main(String args[]) {
		LinkedList heads = new LinkedList();
		LinkedList childs1 = new LinkedList();
		childs1.push(7, null);
		childs1.push(8, null);
		childs1.push(30, null);
		heads.push(5, childs1);
		
		LinkedList childs2 = new LinkedList();
		childs2.push(20, null);
		heads.push(10, childs2);
		
		LinkedList childs3 = new LinkedList();
		childs3.push(22, null);
		childs3.push(50, null);
		heads.push(19, childs3);
		
		LinkedList childs4 = new LinkedList();
		childs4.push(35, null);
		childs4.push(40, null);
		childs4.push(45, null);
		heads.push(28, childs4);
		
		LinkedList flatten = heads.flattenList();
		LinkedList.printAll(flatten.firstNode);
		
	}
}
