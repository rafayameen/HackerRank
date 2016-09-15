package algorithms;

import java.util.Scanner;

public class VeryBigSum
{
	private static long limit = 10000000000L;
	private static long result = 0;
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n < 1 || n > 10)
			return;
		
		long arr[] = new long[n];
		
		for (int arr_i = 0; arr_i < n; arr_i++)
		{
			arr[arr_i] = in.nextLong();
			if(arr_i < 0 || arr_i > limit)
				return;
			
			result += (long)arr[arr_i];
		}
		
		System.out.print(result);
	}
	

}
