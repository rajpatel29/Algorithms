package InsertionSort;

public class MainClass {
	public static void main(String[] args) {

	}

	private static void insertionSort(int[] inputs)
	{
		for(int i = 1 ; i < inputs.length ; i++)
		{
			int temp = inputs[i];
			int index = i;
			for(int j = i - 1 ; j >= 0 ; j--)
			{
				if(temp > inputs[j])
				{
					break;
				}
				else
				{
					int t = inputs[j];
					inputs[j] = inputs[index];
					inputs[index] = t;
					index = j;
				}
			}
		}
	}

}
