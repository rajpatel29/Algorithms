//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set 
//with sum equal to given sum.
//
//Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//Output:  True  //There is a subset (4, 5) with sum 9.

package SubsetSum;

public class MainClass {
	public static void main(String[] args) {
		int inputs[] = {3, 4, 5, 12, 35};
		int sum = 9;
		
		System.out.println("Is Given set a subset sum " + isSubSetSum(inputs, sum));
	}
	
	private static boolean isSubSetSum(int[] inputs, int sum) {
		int noOfElements = inputs.length;
		if(noOfElements == 0)
			return false;
	
		if(noOfElements == 1)
			return (inputs[0] == sum);
		
		
		boolean subSetArray[][] = new boolean[noOfElements][sum+1];
		
		for (int i = 0; i < noOfElements; i++) {
			subSetArray[i][0]= true;
		}
		subSetArray[0][inputs[0]]= true;
		
		
		for (int i = 1; i < noOfElements; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(j < inputs[i]) {
					subSetArray[i][j] = subSetArray[i-1][j];
				} else if(j == inputs[i]) {
					subSetArray[i][j] = true;
				} else {
					if(subSetArray[i-1][j]) {
						subSetArray[i][j] = true;
					} else {
						subSetArray[i][j] = subSetArray[i-1][j-inputs[i]];
					}
				}
			}
			
		}
		
		return subSetArray[noOfElements-1][sum];
	}

	// naive way
	private static Boolean isSubSetSumRecursiveWay(int[] inputs, int sum, int index) {
		if(sum == 0)
			return true;
		
		if(index == inputs.length)
			return false;
		
		if(inputs[index] > sum) 
			return isSubSetSumRecursiveWay(inputs, sum, index+1);
		
		return (isSubSetSumRecursiveWay(inputs, sum-inputs[index], index+1) || isSubSetSumRecursiveWay(inputs, sum, index+1)) ;
	}
}
