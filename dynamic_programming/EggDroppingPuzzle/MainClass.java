/*
The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.

Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break 
on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. 
Drop the egg from the first-floor window; if it survives, drop it from the second floor window. Continue upward until it breaks. In the worst 
case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work
in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that total number 
of trials are minimized.
*/

package EggDroppingPuzzle;

public class MainClass {
	public static void main(String[] args) {
		int n = 19, k = 5689;
		System.out.println("Minimum number of trials in worst case with "+n+" eggs and "+ k+
				" floors is "+ eggDrop(n, k));
	}

	private static int eggDrop(int n, int k) {
		
		int[][] dynamicArray = new int[n+1][k+1];
		
		for (int j = 1; j < dynamicArray[0].length; j++) {
			dynamicArray[1][j] = j;
		}
		
		for (int i = 2; i < dynamicArray.length; i++) {
			dynamicArray[i][1] = 1;
			int current = 1;
			for (int j = 2; j < dynamicArray[0].length; j++) {
				int index = j;
				while(current <= dynamicArray[i-1][index-1]) {
					index--;
				}
				dynamicArray[i][j] = Math.max(dynamicArray[i-1][index] , 1 + dynamicArray[i][j - index ] );
				current = dynamicArray[i][j];
			}
		}
		
		return dynamicArray[n][k];
	}
}
