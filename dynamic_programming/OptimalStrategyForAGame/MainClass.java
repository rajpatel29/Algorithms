package OptimalStrategyForAGame;

public class MainClass {
	public static void main(String[] args) {
		int input1[] = {8, 9};
		System.out.println(optimalStrategyOfGame(input1, 0, input1.length-1));
	}

	private static int optimalStrategyOfGame(int[] input, int start, int end) {
		if (start + 1 == end ) {
			return Math.max(input[start], input[end]);
		}
		
		int temp1 = input[start] + Math.min( optimalStrategyOfGame(input, start+2, end) , optimalStrategyOfGame(input, start+1, end-1));
		
		int temp2 = input[end] +  Math.min(optimalStrategyOfGame(input, start, end-2), optimalStrategyOfGame(input, start+1, end-1));
		
		return Math.max(temp1, temp2);
	}
}
