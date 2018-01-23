package LongestCommonSubsequence;

public class MainClass {
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		int lcr = findLongestCommonSubsequence(s1, s2);
		System.out.println("Longest common Sebsequence of " + s1 + " and " + s2 + " is " + lcr);
	}

	private static int findLongestCommonSubsequence(String input1, String input2) {
		int rows = input1.length();
		int cols = input2.length();
		
		char chars1[] = new char[rows+1];
		input1.getChars(0, rows, chars1, 1);
		
		char chars2[] = new char[cols+1];
		input2.getChars(0, cols, chars2, 1);
		
		int[][] LCR = new int[rows+1][cols+1];
				
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if(chars1[i] == chars2[j]) {
					LCR[i][j] = LCR[i-1][j-1] + 1;
				} else {
					LCR[i][j] = Math.max(LCR[i][j-1], LCR[i][j-1]);
				}
			}
		}
		
		return LCR[rows][cols];
	}
}
