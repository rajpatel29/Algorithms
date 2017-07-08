package Least_Frequently_Used_LFU;

import java.util.LinkedHashSet;

public class Node {
	public int count = 0;
    public LinkedHashSet<Integer> keys = null;
    public Node prev = null, next = null;
	
	public Node(int count) {
        this.count = count;
        keys = new LinkedHashSet<Integer>();
        prev = next = null;
    }
}
