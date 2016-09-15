package algorithms;

import java.util.Scanner;

public class LeftAndRightPyramid
{

	
	public static void main(String[] args)
	{
		int totalSpaces = 0;
		int row, col;
		String star = "*";
		String space = " ";
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		
		totalSpaces += (size+size)-1;
		
		for(row = 1 ; row <= size; row++)
		{
			totalSpaces -= 2;
			
			for(col = 1; col <= row; col++)
			{
				System.out.print(star);
			}
			
			printSpaces(space, size, row, totalSpaces);
			
			for(col = 1; col <= row; col++)
			{
				System.out.print(star);
			}
			
			System.out.println();
			
		}
				
	}

	private static void printSpaces(String space, int size, int row, int totalSpaces)
	{
		
		for(int spaces = 1; spaces <= totalSpaces; spaces++)
		{
			System.out.print(space);
		}
		
	}

}
