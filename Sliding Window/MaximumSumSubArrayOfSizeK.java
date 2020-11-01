//https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
/**
* Given an array find maximum size
* Sub - Array of size 'K'
* sliding window problem
*/

import static java.lang.System.*;

public class MaximumSumSubArrayOfSizeK
{
	public static void main(String [] args)
	{
		int A[] = new int[]{1,2,3};
		int k = 3;
		int n = A.length;
		out.println(solve(A, n, k));
	}
	
	static int solve(int A[], int n, int k)
	{
		int max = 0;
		int sum = 0;
		
		for(int i=0;i<k; i++)
			sum = sum + A[i];
		
		max = sum;
		
		for(int i = k; i<n ; i++)
		{
			sum = sum + A[i] - A[i-k];
		    if(max < sum)
				max = sum;
		}
		
		return max;
	}
}