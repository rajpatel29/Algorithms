package Fibonacci_without_Recursion;

public class MainClass 
{
	public static void main(String[] args) 
	{
		int  n = 10;
		int answer[] =  Fibonacci(n);
		
		for(int  i = 0 ; i< n ; i++)
		{
			System.out.println(answer[i]);
		}
	}

	private static int[] Fibonacci(int n) 
	{
		int array[] = new int[n];
	
		for(int i = 0 ; i < n ;i++)
		{
			if(i == 0 )
			{
				array[0] = 0;
			}
			else if(i == 1)
			{
				array[1] = 1;
			}
			else
			{
				array[i] = array[i-1] + array[i-2];
			}
		}
		
		return array;
	}
}
