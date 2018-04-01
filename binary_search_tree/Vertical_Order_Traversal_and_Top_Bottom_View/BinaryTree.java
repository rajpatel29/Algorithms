package Vertical_Order_Traversal_and_Top_Bottom_View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BinaryTree {
	HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	
	public void verticalTraversal(Node root) {
		inOrder(root, 0);
		
		Set keys = map.keySet();
		
		Iterator<Integer> it = keys.iterator();
	     while(it.hasNext()){
	        ArrayList list = map.get(it.next());
	        for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
	        System.out.println();
	     }
	}
	
	public void inOrder(Node root, int index) {
		if(root == null)
			return;
		
		if(map.containsKey(index)) {
			int data = root.data;
			map.get(index).add(root.data);
		} else {
			ArrayList<Integer> newList = new ArrayList<>();
			newList.add(root.data);
			map.put(index, newList);
		}
		
		if(root.left != null)
			inOrder(root.left, index-1);
		
		if(root.right != null)
			inOrder(root.right, index+1);
	}
	

}
