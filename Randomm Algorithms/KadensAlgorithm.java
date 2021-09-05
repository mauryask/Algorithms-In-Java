/*
* T(n) : O(n)
* S(n) : O(1)
******
Sub array with largest sum
************
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
*/

import static java.lang.System.*;
import java.util.*;

public class KadensAlgorithm
{
	
	static int subArrayWithLargestSum(int[] A, int n)
	{
		/* corner case */
		
		if(n == 0)
			return 0;
		
		/*
		* start and end index
		* of largest sum subarray
		*/
		
		int start = 0, end = 0;
		
		/*
		* If there is only one element 
		* then it is itself greatest element (Nir-virodh)
		*/
		
		int sum = A[0];
		int maxSum = A[0];
		
		for(int i=1; i<n; i++)
		{
			/*
			* Idea behind the algorithm: 
			* **************
			* Here tendency of each element 
			* is to increase itself
			****************
			* if on addition of Ai to the sum, 
			* the sum becomes less than the Ai
			* then Ai will not go with the sum
			* instead it will start a new sum (see else part)
			*/
			
			if(sum + A[i] > A[i])
			{
				sum += A[i];
				
				if(maxSum < sum)
				{
					maxSum = sum;
					end = i;
				}
			}
			else
			{
				sum = A[i];
				start = i;
			}
		}
			
		for(int i=start; i<=end; i++)
			out.print(A[i]+" ");
		out.println();
		return maxSum;
	}
	
	
	/*
	* T(n) : O(n*n)
	* S(n) : O(1)
	*/
	
	static int bruteForce(int A[], int n)
	{
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		int start = 0, end = 0;
		
		for(int i=0; i<n; i++)
		{
			sum = 0;
			
			for(int j=i; j<n; j++)
			{
				sum += A[j];
				
				if(sum > maxSum)
				{
					maxSum = sum;
					start = i;
					end = j;
				}
			}
		}
		
		for(int i=start; i<=end; i++)
			out.print(A[i]+" ");
		out.println();
		return maxSum;
	}
	
	public static void main(String [] args)
	{
		int A[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int n = A.length;
		
		out.println(subArrayWithLargestSum(A, n));
		//out.println(bruteForce(A, n));
	 }
}