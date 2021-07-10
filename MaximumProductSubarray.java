// Queation Number :  #18

import static java.lang.System.*;
import java.util.*;

public class MaximumProductSubarray
{
	public static void main(String [] args)
	{
		int A[] = {2,-3,-6,9,4,-3};
		out.println(maxProduct(A));
	}
	
	// Time Complexity  : O(n)
	// Space Complexity : O(1)
	
	static int maxProduct(int A[])
	{
		int n = A.length;
		int max_product =  A[0];
		int min_product  =  A[0];
        int result =  A[0];
		boolean flag = false;
		
		for(int i=1;i<n; i++)
		{
			 int temp = max_product;
			 max_product = Math.max(A[i], Math.max(max_product*A[i],
			 min_product*A[i]));
			 
			 min_product = Math.min(A[i], Math.min(temp*A[i],
			 min_product*A[i]));
			 
			 if(result < max_product)
				 result = max_product;
		}
		
		return result;
	}
	
	
	// Time Complexity  : O(n^2)
	// Space Complexity : O(1)
	
	static int maxProduct2(int A[])
	{
		int max_product = Integer.MIN_VALUE;
		int n = A.length;
		int product = 1;
		
		for(int i=0; i<n; i++)
		{
			product =  A[i];
			
			for(int j=i+1; j<n; j++)
			{
				max_product = Math.max(product, max_product);
				product *= A[j];
			}
			max_product = Math.max(product, max_product);
		}
		
		return max_product;
	}
}