package Sorting;

public class TestClass
{
	public static void main(String[] args)
	{
		int inputs[] = {38, 27,43,3,9,82,10};

		quickSort(inputs);

		for(int  i = 0 ; i < inputs.length ;i++)
		{
			System.out.println(inputs[i]);
		}
	}

	private static void quickSort(int[] inputs)
	{
		quickHelper(inputs , 0 , inputs.length-1);
	}

	private static void quickHelper(int[] inputs, int start, int end)
	{
		int  i = start;
		int  j = end;
		int pivot = inputs[start + ((end - start)/2) ];

		while(i <= j)
		{
			while(inputs[i] < pivot)
			{
				i++;
			}

			while(inputs[j] > pivot)
			{
				j--;
			}

			if(i <= j)
			{
				int temp = inputs[i];
				inputs[i] = inputs[j];
				inputs[j] = temp;
				i++;
				j--;
			}
		}

		if(start < j )
			quickHelper(inputs , start , j );

		if(i < end)
			quickHelper(inputs , i , end);
	}







	private static void mergeSort(int[] inputs)
	{
		divideAndMerge(inputs , 0 , inputs.length - 1);
	}

	private static void divideAndMerge(int[] inputs, int start, int end)
	{
		if(start < end)
		{
			int mid = start +  ( end  - start) /2;
			divideAndMerge(inputs , 0 , mid);
			divideAndMerge(inputs , mid + 1 , end);
			merge(inputs , 0 , mid , end);
		}
	}

	private static void merge(int[] inputs, int start, int mid, int end)
	{
		int[] tempInput = new int[inputs.length];
		for(int  i = 0 ; i < inputs.length ; i++ )
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

	private static void bubbleSort(int[] inputs)
	{
		for(int  i = 0 ; i < inputs.length - 1 ; i++)
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

	private static void insertionSort(int[] inputs)
	{
		for(int  i = 1 ; i < inputs.length ; i++)
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
					int  t = inputs[j];
					inputs[j] = inputs[index];
					inputs[index] = t;
					index = j;
				}
			}
		}
	}
}
