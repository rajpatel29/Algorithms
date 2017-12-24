package DijkstraShortestPath;

import DijkstraShortestPath.BinaryMinHeap.Node;

public class MainClass {
	public static void main (String args[]) {
		BinaryMinHeap<String> heap = new BinaryMinHeap<String>();
		heap.add(5,"Person 5");
		heap.add(3,"Person 3");
		heap.add(7,"Person 7");
		heap.add(1,"Person 1");
		heap.add(9,"Person 9");
		heap.add(4,"Person 4");
		heap.add(2,"Person 2");
		
		System.out.println("Before =>");
		heap.printAllNodes();
		
		System.out.println("Decrease");
		heap.decrease("Person 7", 0);
		System.out.println("After =>");
		heap.printAllNodes();
	
		
	}
}
