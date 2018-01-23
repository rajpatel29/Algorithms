//Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell) 
//such that all cells along the path are in increasing order with a difference of 1.
//
//We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) 
//with the condition that the adjacent cells have a difference of 1.
//
//Example:
//
//Input:  mat[][] = {{1, 2, 9}
//                   {5, 3, 8}
//                   {4, 6, 7}}
//Output: 4
//The longest path is 6-7-8-9. 


package LongestPathInMatrix;

public class MainClass {
	public static void main(String[] args) {
		int  matrix[][] = {{1, 2, 9},
        {5, 3, 8},
        {4, 6, 7}};
		System.out.println("Length of the longest path is " + findLongestPath(matrix));
	}

	private static int findLongestPath(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int flp[][] = new int[rows][cols];
		int max = 1;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(flp[i][j] == 0) 
					flp[i][j] = findLongestPathHelper(i, j, matrix, matrix[i][j]-1, flp);
				
				max = Math.max(max, flp[i][j]);
			}
		}
		
		return max;
	}

	private static int findLongestPathHelper(int row, int col, int[][] matrix, int threshold, int[][] flp) {
		if(row >= matrix.length || row < 0 || col < 0 || col >= matrix[0].length ) {
			return 0;
		}
		
		if(threshold + 1 != matrix[row][col]  ) {
			return 0;
		}
		
		if(flp[row][col] != 0)
			return flp[row][col];
		
		if(row-1 >= 0 && matrix[row][col] + 1 == matrix[row-1][col]) {
			flp[row][col] = 1 + findLongestPathHelper(row-1,col, matrix, matrix[row][col], flp);
			return flp[row][col];
		}
		
		if(col-1 >= 0 && matrix[row][col] + 1 == matrix[row][col-1]) {
			flp[row][col] = 1 + findLongestPathHelper(row,col-1, matrix, matrix[row][col], flp);
			return flp[row][col];
		}
		
		if(row+1 < matrix.length && matrix[row][col] + 1 == matrix[row+1][col]) {
			flp[row][col] = 1 + findLongestPathHelper(row+1,col, matrix, matrix[row][col], flp);
			return flp[row][col];
		}
		
		if(col+1 < matrix[0].length && matrix[row][col] + 1 == matrix[row][col+1]) {
			flp[row][col] = 1 + findLongestPathHelper(row,col+1, matrix, matrix[row][col], flp);
			return flp[row][col];
		}
		
		flp[row][col] = 1;
		return flp[row][col];
	}
}
