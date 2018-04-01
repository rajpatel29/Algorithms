package MergeSort;

public class MainClass {
	public static void main(String[] args) {

	}
	
	private static void mergeSort(int[] inputs)
	{
		divideAndMerge(inputs , 0 , inputs.length - 1);
	}
	
	private static void divideAndMerge(int[] inputs, int start, int end)
	{
		if(start < end)
		{
			int mid = start + ( end - start) /2;
			divideAndMerge(inputs , 0 , mid);
			divideAndMerge(inputs , mid + 1 , end);
			merge(inputs , 0 , mid , end);
		}
	}

	private static void merge(int[] inputs, int start, int mid, int end)
	{
		int[] tempInput = new int[inputs.length];
		for(int i = 0 ; i < inputs.length ; i++ )
		{
			tempInput[i] = inputs[i];
		}
		
		int i = start;
		int j = mid + 1 ;
		int k = start;
		while(i <= mid && j<=end )
		{
			if(tempInput[i] < tempInput[j])
			{
				inputs[k] = tempInput[i];
				k++;
				i++;
			}
			else
			{
				inputs[k] = tempInput[j];
				k++;
				j++;
			}
		}
		
		while(i <= mid)
		{
			inputs[k] = tempInput[i];
			k++;
			i++;
		}
		if(j<=end)
		{
			inputs[k] = tempInput[j];
			k++;
			j++;
		}
	}
}
