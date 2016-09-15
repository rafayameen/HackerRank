package algorithms;

import java.util.Scanner;

public class SimpleArraySum
{
	public static void main(String[] args)
	{
		int result = 0;
		 @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int arr[] = new int[n];
	        for(int arr_i=0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	            result+= arr[arr_i];
	            
	        }
	        
	        System.out.println(result);
	}

}
