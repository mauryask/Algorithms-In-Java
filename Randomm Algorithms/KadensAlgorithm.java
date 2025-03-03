 /*
* T(n) : O(n)
* S(n) : O(1)
******
Sub array with largest sum
************
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
*/

import static java.lang.System.*;

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
		
         int maxSum = 0;
         int sum = 0;
         int temp = 0; 
		 int start = 0;
		 int end = 0;
		
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
		
        for(int i=0; i<n; i++)
        {
            if(sum + A[i] > A[i])
                sum += A[i];
            else
			{
				temp = i;
				sum  = A[i];
			}
            
            if(maxSum < sum)
		    {
			   maxSum = sum;
			   start = temp;
			   end = i;
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
		int A[] = {-2,1,-3,4,-1,2,1,-7,4};
		int n = A.length;
		
		out.println(subArrayWithLargestSum(A, n));
		//out.println(bruteForce(A, n));
	 }
}