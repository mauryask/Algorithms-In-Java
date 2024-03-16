/*
* Time complexity  : O(n)
* Space complexity : O(1)
*******************
** fixed size window
*/
import static java.lang.System.*;
import java.util.*;

public class FirstNegativeNumberInEachWindowOfSizeK
{
	static void printNegative(int A[], int n, int k)
	{
		int i=0, j=0;
		List<Integer> list = new LinkedList<>();
		
		while(j<n)
		{
			if(A[j] < 0)
				list.add(A[j]); 
						
			if(j-i+1 == k)
			{
				/*
				* '*' means the window do not have a
				* negative number
				*/
				String rslt = !list.isEmpty() ?
				list.get(0)+"" : "*";
				out.print(rslt+" ");
				
				/*
				* same as in max sum subarray
				* we do sum - Ai i.e.
				* we remove all the calculations of Ai
				* before moving to next window
				******************************
				* same thing we will do here
				* remove Ai from the list if present
				* and then slide the window
				*/
				
				if(!list.isEmpty() && list.get(0) == A[i])
				   list.remove(0);
			   
				i++;
			}
			
			j++;
		}
	}
	
	
	/*
	* T(n) = O(n*k)
	* S(n) = O(1)
	*/
	static void bruteForce(int A[], int n, int k)
	{
		for(int i=0; i<=n-k; i++)
		{
			boolean flag = false;
					
			for(int j = i; j<i+k; j++)
			{
				// if first -ve found 
				// print it and break the loop
				if(A[j] < 0)
				{
					out.print(A[j]+" ");
					flag = true;
					break;
				}
				
			}
			
			// -ve number not present in the window
			// print 0
			if(!flag)
				out.print(" * ");
		}
	}
	
	public static void main(String [] args)
	{
		int A[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int n = A.length;
		int k = 3; // window size
		
		printNegative(A, n, k);
		//bruteForce(A, n, k);
	}
}
