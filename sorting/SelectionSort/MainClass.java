package SelectionSort;

public class MainClass {
	public static void main(String[] args) {

	}
	
	private static void selectionSort(int[] inputs)
	{
		for(int i = 0 ; i < inputs.length - 1 ; i++)
		{
			for(int j = i+1 ; j < inputs.length ;j++)
			{
				if(inputs[i] > inputs[j])
				{
					int temp = inputs[i];
					inputs[i] = inputs[j];
					inputs[j] = temp;
				}
			}
		}
	}

}
