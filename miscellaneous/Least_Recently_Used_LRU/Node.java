package Least_Recently_Used_LRU;

public class Node {
	public int key;
    public Node prev = null, next = null;
	
	public Node(int key) {
        this.key = key;
        prev = next = null;
    }
}
