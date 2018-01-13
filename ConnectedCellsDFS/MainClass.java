//Given an  matrix, find and print the number of cells in the largest region in the matrix. 
//Note that there may be more than one region in the matrix.
//
//Input : mat[][] = {{1, 1, 0, 1, 0},
//                   {0, 1, 0, 1, 1},
//                   {1, 0, 0, 1, 1},
//                   {0, 0, 0, 1, 0},
//                   {1, 0, 0, 0, 1} 
//Output : 7

package ConnectedCellsDFS;

public class MainClass {
	public static void main(String[] args) {
		int M[][]=  new int[][] {
			{1, 1, 0, 1, 0},
            {0, 1, 0, 1, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 1, 0},
            {1, 0, 0, 0, 1}
           };
           
		System.out.println("Number of islands is: "+ countRegion(M));
	}

	private static int countRegion(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if(matrix[row][col] == 1) {
					int size = getRegionCount(matrix, row, col);
					System.out.println("row: " + row + " col: " + col + " size: " + size);
					max = Math.max(size, max);
				}
			}
		}
		
		return max;
	}

	private static int getRegionCount(int[][] matrix, int row, int col) {
		if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) 
			return 0;
		
		if(matrix[row][col] == 0)
			return 0;
		
		int size = 1;
		matrix[row][col] = 0;
		for (int i = row-1; i <= row+1; i++) {
			for (int j = col-1; j <= col+1; j++) {
				size += getRegionCount(matrix, i, j);
			}
		}
		
		return size;
	}
}
