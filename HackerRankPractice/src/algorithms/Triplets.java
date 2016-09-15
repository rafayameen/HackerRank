package algorithms;

import java.util.Scanner;

public class Triplets
{
    public static void main(String[] args) {
    	int alice_points = 0;
    	int bob_points = 0;
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        
        int[] arr_a= {a0, a1, a2};
        int[] arr_b= {b0, b1, b2};

        for(int i = 0; i < 3; i++)
        {
        	if(arr_a[i] > arr_b[i])
        		alice_points++;
        	else if(arr_b[i] > arr_a[i])
        		bob_points++;
        	else
        	{
        		alice_points +=0;
        		bob_points +=0;
        	}
        }
        
        System.out.print(alice_points + " " + bob_points);
        
        
    }

}
