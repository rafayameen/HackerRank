package algorithms;

import java.util.Scanner;

public class DiagonalDIfference
{
	public static void main(String[] args)
	{
		int absoluteValue = 0;
		int primaryDiagonal = 0;
		int secondaryDiagonal = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		int s[][] = new int[n][n];

		for (int a_i = 0; a_i < n; a_i++)
		{
			for (int a_j = 0; a_j < n; a_j++)
			{
				a[a_i][a_j] = sc.nextInt();
				s[a_i][a_j] = a[a_i][a_j];
				if(a_i == a_j)
				{
					primaryDiagonal += a[a_i][a_j];
				}

			}
			
		}
		
		int j = n-1;
		while(j != 0)
		{
			for(int i = 0; i< n; i++)
			{
				secondaryDiagonal += a[i][j];
				j--;
			}
			break;
		}
		
		
		absoluteValue = Math.abs(primaryDiagonal-secondaryDiagonal);
		System.out.print(absoluteValue);

	}

}
