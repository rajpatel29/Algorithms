//Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
//
//Examples:
//
//Input:  n = 3
//Output: 4
//Below are the four ways
// 1 step + 1 step + 1 step
// 1 step + 2 step
// 2 step + 1 step
// 3 step
//
//Input:  n = 4
//Output: 7

package WaysToCoverADistance;

public class MainClass {
	public static void main(String[] args) {
		int n = 30;
		System.out.println("Number of ways to cover a distance " + printCount(n));
	}

	private static int printCount(int n) {
		int dynamicArray[] = new int[n+1];
		
		if( n<=2 ) {
			return n;
		} else if( n == 3 ) {
			return 4;
		}
		
		dynamicArray[1] = 1;
		dynamicArray[2] = 2;
		dynamicArray[3] = 4;
		
		for (int i = 4; i < n+1; i++) {
			dynamicArray[i] = dynamicArray[i-1]  + dynamicArray[i-2]  + dynamicArray[i-3]; 
		}
		
		return dynamicArray[n];
	}
	
}
