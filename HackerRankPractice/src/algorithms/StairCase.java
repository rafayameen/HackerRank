package algorithms;

import java.util.Scanner;

public class StairCase
{
	public static void main(String[] args)
	{
		int row, col;
		String hash = "#";
		String space = " ";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		for (row = 1; row <= size; row++)
		{

			for (int spaces = 1; spaces <= size - row; spaces++)
			{
				System.out.print(space);
				
			}
			for(col = 1; col <= row; col++)
			{
				System.out.print(hash);
			}
			System.out.println();
		}

	}

}
