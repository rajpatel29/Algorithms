package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	  
	  public static class Potential {
	    int sum;
	    List<Integer> partial;
	    List<Integer> remaining;

	    public Potential(int s, List<Integer> p, List<Integer> r) {
	      sum = s;
	      partial = p;
	      remaining = r;
	    }

	    public String toString()
	    {
	      return "(" + sum + ", " + Arrays.toString(partial.toArray()) 
	        + ", " + Arrays.toString(remaining.toArray()) + ")"; 
	    }
	  }
	  
	  static void subsetSum_BFS(List<Integer> numbers, int target) {
	    Queue<Potential> queue = (Queue<Potential>) new LinkedList();

	    Potential start = new Potential(0, new ArrayList<Integer>(), numbers);
	    queue.add(start);

	    while (!queue.isEmpty()) {
	      Potential current = queue.remove();
	      int sum = current.sum;
	      
	      for (int i = 0; i < current.remaining.size(); i++) {
	        List<Integer> remaining = new ArrayList<Integer>();
	        int n = current.remaining.get(i);
	        sum += n;
	        List<Integer> partial = new ArrayList<>(current.partial);
	        partial.add(n);

	        if (sum == target) {
	          System.out.println("sum="+target);
	          System.out.println(Arrays.toString(partial.toArray()));
	          return;
	        }

	        for (int j= i + 1; j < current.remaining.size(); j++) {
	          remaining.add(current.remaining.get(j));
	        }
	        Potential next = new Potential(sum, partial, remaining);
	        queue.add(next);
	                
	        sum -= n;
	      }
	    }
	    System.out.println("Matching subset not found.");
	  }

	  static void removeZeroSum(List<Integer> numbers) {
	    int sum = 0;
	    for (Integer n : numbers) {
	      sum += n;
	    }
	    System.out.println("target="+sum);
	    if (sum == 0) {
	      System.out.println("[]");
	      System.out.println("Subset empty, bypassing search.");
	      return;
	    }
	    subsetSum_BFS(numbers, sum);
	  }
	  
	  public static void main(String[] args) {
	    
		// case 1: 6 -6 8 4 -12 9 -8 8
		    // O/P : 9
		    Integer[] case1 = {6, -6, 8, 4, -12, 9, -8, 8};
		    List<Integer> case1List = new LinkedList<>(Arrays.asList(case1));
		    removeZeroSum(case1List);
		    
		    // case 2: 20, 5, 6, 10, -11, 10, 2, 2
		    // O/P : 20 2 2
		    Integer[] case2 = {20, 5, 6, 10, -11, -10, 2, 2};
		    List<Integer> case2List = new LinkedList<>(Arrays.asList(case2));
		    removeZeroSum(case2List);
		    
		    // case 3 : 4 6 -10 8 9 10 -19 10 -18 20 25 
		    // O/P : 20 25
		    Integer[] case3 = {4, 6, -11, 8, 5};
		    List<Integer> case3List = new LinkedList<>(Arrays.asList(case3));
		    removeZeroSum(case3List);
	  }
	}