package QuickSort;

public class MainClass {

	public static void main(String[] args) 
	{
		int array[] = {4, 3, 9, 1, 5, 7, 6};
		quickSort(array);
		
		for (int i = 0; i < array.length; i++) 
		{
			System.out.println(array[i]);
		}
	}
	
	public static void quickSort(int array[] )
	{
		quickSortRecursion(array , 0 , array.length -1);
	}
	
	public static void quickSortRecursion(int array[] , int start , int end)
	{
		int idx = partition(array , start , end);
		
		
		
		if(start < idx - 1)
		quickSortRecursion(array , start , idx-1);
		
		
		if(idx + 1  < end)
			quickSortRecursion(array , idx + 1 , end);
	}

	private static int partition(int[] array, int start, int end) 
	{
		int pivot = start;
		
		while(start <= end)
		{
			while(array[start] < array[pivot] )
			{
				start++;
			}
			
			while(array[end] > array[pivot] )
			{
				end--;
			}
			
			if(start <= end)
			{
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
		
		return start ;
	}
}
