package LongestIncreasingSubsequence;

public class MainClass {
	public static void main(String[] args) {
		int inputs[] = {2, 7, 1, 10, 3, 4, 9, 6};
		
        System.out.println("Longest Increasing Subsequence is "+ findLongestIncreasingSubsequence(inputs));
	}
	
	private static int findLongestIncreasingSubsequence(int[] inputs) {
		int max = 1;
		int length = inputs.length;
		
		if(inputs.length == 0)
			return 0;
		
		if(inputs.length == 1)
			return 1;
		
		int lcr[] = new int[length];
		
		for (int i = 0; i < length; i++) {
			lcr[i] = 1;
		}
		
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if(inputs[j] < inputs[i]) {
					int tempLCR = lcr[j] + 1;
					lcr[i] = Math.max(lcr[i], tempLCR);
				}
			}
			
			if(max < lcr[i]) {
				max = lcr[i];
			}
		}

		return max;
	}
}
