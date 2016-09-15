package algorithms;

import java.util.Scanner;

public class BothSidesPyramid
{
	private static int totalStars = 1;
	public static void main(String[] args)
	{
		int row, col;
		String star = "*";
		String space = " ";
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		
		for(row = 1 ; row <= size; row++)
		{
			
			printSpaces(space, size, row);
			for(col = 1; col <= totalStars; col++)
			{
				System.out.print(star);
			}
			printSpaces(space, size, row);
			System.out.println();
			totalStars += 2;
			
		}
				
	}

	private static void printSpaces(String space, int size, int row)
	{
		for(int spaces = 1; spaces <= size - row; spaces++)
		{
			System.out.print(space);
		}
		
	}

}
