package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class KangarooAlgorithm
{
   	private static ArrayList<Integer>	x1List		= new ArrayList<Integer>();
	private static ArrayList<Integer>	x2List		= new ArrayList<Integer>();

	public static void main(String[] args)
	{

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int v1 = sc.nextInt();
		int x2 = sc.nextInt();
		int v2 = sc.nextInt();
		// x1 >=0 and x1 <= 10000 also x1<x2
		if(x1 < 0 || x1 > 10000 || x1 >= x2)
			return;
		// x2>=0 and x2<= 10000 also x2>x1
		if(x2 < 0 || x2 > 10000 || x2 <= x1)
			return;
		if(!checkVelocity(v1) || !checkVelocity(v2))
			return;
		
		if(checkLanding(x1, v1, x2, v2))
			System.out.println("YES");
        else
            System.out.println("NO");



	}

	private static boolean checkVelocity(int v)
	{
		if(v < 1 || v > 10000)
			return false;
		else
			return true;
	}

	private static boolean checkLanding(int x1, int v1, int x2, int v2)
	{
        

		x1List.add(x1);
		x2List.add(x2);
		boolean sameLanding = false;
		while(!sameLanding)
		{
			
			int jumpSequence1 = x1 + v1;
			x1 = jumpSequence1;
			x1List.add(jumpSequence1);

			int jumpSequence2 = x2 + v2;
			x2 = jumpSequence2;
			x2List.add(jumpSequence2);
		
			if(x1 == x2)
			{
				if(x1List.indexOf(x1) == x2List.indexOf(x2))
					sameLanding = true;
			}
			
			//x1 should be less than x2 and v1 greater than  v2 
			//in order for kangaroo 1 to catch up
			//if not the case then return false
			
			if(x1 > x2 || v2 > v1)
			{
				return false;
			}
			else if(x2 > x1 && v1 == v2)	//if x2 is greater and velocities are equal then 
				return false;				//kangaroos never gonna catch up so return false
			
		}
	   
       return true;

	}

}
