package BubbleSort;

public class MainClass {

	public static void main(String[] args) {

	}
	
	private static void bubbleSort(int[] inputs)
	{
		for(int i = 0 ; i < inputs.length - 1 ; i++)
		{
			for (int j = 0; j < inputs.length - i - 1; j++)
			{
				if(inputs[j] > inputs[j+1])
				{
					int temp = inputs[j];
					inputs[j] = inputs[j +1];
					inputs[j + 1] = temp;
				}
			}
		}
	}


}
