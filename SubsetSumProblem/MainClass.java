package SubsetSumProblem;

public class MainClass {
	public static void main (String args[])
    {
		int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
           System.out.println("Found a subset with given sum");
        else
           System.out.println("No subset with given sum");
    }

	private static boolean isSubsetSum(int[] set, int n, int sum) {
		boolean table[][] = new boolean[n][sum+1];
		for(int i = 0 ; i <n; i++) {
			table[i][0] = true;
		}
		
		for(int i=1 ; i<sum+1; i++) {
			if(set[0] == i) {
				table[0][i] = true;
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j=1 ; j<sum+1; j++) {
				if(table[i-1][j] || (j == set[i])) {
					table[i][j] = true;
				} else if (j - set[i] < 0)  {
					
				} else if(table[i-1][j-set[i]]){
					table[i][j] = true;
				}
			}
		}
	
//		print the table
//		for (int i = 0; i < table.length; i++) {
//			System.out.print(set[i] + "\t");
//			for (int j = 0; j < table[i].length; j++) {
//				System.out.print(table[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return table[n-1][sum];
	}
}
