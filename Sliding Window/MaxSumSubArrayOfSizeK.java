/*
* Time complexity: O(n)
* Spce complexity: O(1)
*******
Fixed size window
*/

import static java.lang.System.*;
import java.util.*;

public class MaxSumSubArrayOfSizeK
{
	static int maxSum(int A[], int n, int k)
	{
		int i=0, j=0;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		while(j<n)
		{
			 sum += A[j];

			/*
			* If given window size is achieved
			* find max sum
			* increse 'i' to point start of another 
			* window of same size
			*/
			 if(j-i+1 == k)
			 {
				 maxSum = Math.max(sum, maxSum);
				 sum -= A[i];
				 i++;
			 }
			 
			 j++;
		}
		
		return maxSum;
	}
	
	/*
	* T(n) = O(n*k)
	* S(n) = O(1)
	*/
	static int bruteForce(int A[], int n, int k)
	{
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0; i <= n-k; i++)
		{
			int sum = 0;			
		
		    for(int j=i; j<i+k; j++)
				sum += A[j];
			
			maxSum = Math.max(sum, maxSum);
		}
		
		return maxSum;
	}
	
	public static void main(String [] ags)
	{
		int A[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		int n = A.length;
		int k = 4; //window size
		
		//out.println(maxSum(A, n, k));
		 out.println(bruteForce(A, n, k));
	}
}