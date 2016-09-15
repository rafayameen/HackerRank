package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class PlusMinus
{
	private static ArrayList<Integer>	positives	= new ArrayList<Integer>();
	private static ArrayList<Integer>	negatives	= new ArrayList<Integer>();
	private static ArrayList<Integer>	zeros		= new ArrayList<Integer>();

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++)
		{
			arr[arr_i] = in.nextInt();
			if(arr[arr_i] > 0)
				positives.add(arr[arr_i]);
			else if(arr[arr_i] < 0)
				negatives.add(arr[arr_i]);
			else if(arr[arr_i] == 0)
				zeros.add(arr[arr_i]);

		}
		Integer size = n;
		Integer positivesSize = positives.size();
		Integer negativesSize = negatives.size();
		Integer zerosSize = zeros.size();

		System.out.println(Float.parseFloat(positivesSize.toString()) / Float.parseFloat(size.toString()));
		System.out.println(Float.parseFloat(negativesSize.toString()) / Float.parseFloat(size.toString()));
		System.out.println(Float.parseFloat(zerosSize.toString()) / Float.parseFloat(size.toString()));

	}

}
