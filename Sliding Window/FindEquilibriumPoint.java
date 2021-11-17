/*
* T(n) : O(n) 
* S(n) : O(1)
****************
* Sliding window
** https://www.geeksforgeeks.o7rg/equilibrium-index-of-an-array/
*/
import static java.lang.System.*;
import java.util.*;

public class FindEquilibriumPoint 
{
	static int equilibriumPoint(int[] A, int n)
	{
		   int s1 = 0;	
		   int s2  = 0;
		   
		  for(int x : A)
			s2 += x;
		
		 for(int i = 0; i<n; i++)
		 {
			if(i != 0)
				s1 += A[i-1];
			s2 -= A[i];
           
            if(s1 == s2)
              return i;				
		 }
		 
		 return -1;
	}
	
	public static void main(String [] args)
	{
		int A[] = {-7, 1, 5, 2, -4, 3, 0};
		int n = A.length;
		out.println(equilibriumPoint(A, n));
	}
}