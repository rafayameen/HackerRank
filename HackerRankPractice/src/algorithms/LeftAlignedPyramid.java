package algorithms;

import java.util.Scanner;

public class LeftAlignedPyramid
{

	public static void main(String[] args)
	{
		String star = "*";
		String dash = "-";
		int row, col;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		row = col = size;

		printStarsOnly(row, size, col, star);
		System.out.println("\t\t\t");
		printDashedStars(row, size, col, star, dash);

	}

	private static void printDashedStars(int row, int size, int col, String star, String dash)
	{
		// TODO Auto-generated method stub
		for(row = 0; row < size; row++)
		{
			for(int dashes = 0; dashes < row; dashes++)
			{
				System.out.print(dash);
			}
			
			for(col = 0; col < 1; col++)
			{
				System.out.print(star);
			}
			System.out.println();
		}
		
	}

	private static void printStarsOnly(int row, int size, int col, String star)
	{
		// TODO Auto-generated method stub
		for (row = 1; row <= size; row++)
		{
			for(col = 1; col <= row; col++)
			{
				System.out.print(star);
			}
			System.out.println();

		}
		
	}

}
