/*
* Time complexity  : O(n)
* Space complexity : O(n)
*****************
** variable size window
** https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
*/

import static java.lang.System.*;
import java.util.*;

public class LargestSubArrayWithSumK
{
	static int largestSubArray(int A[], int n, int k)
	{
		// this map stores the previous sums
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxLen = 0;
		
		for(int i=0; i<n; i++)
		{
			// cumulative sum
			sum += A[i]; 
			
			// if subarray starts from 0
			if(sum == k)
				maxLen = i+1;

			// put the sum in the map
			// id it is absent along with the index
		    map.putIfAbsent(sum ,i);
			
			// check if (sum - k already exists)
			if(map.containsKey(sum-k))		       
				 maxLen = Math.max(maxLen, i-map.get(sum-k));
		}
		return maxLen;
	}
	
	/*
	* Time complexity: O(n*n)
	* Spce complexity: O(1)
	******************
	* Idea is to find all the windows having 
	* sum == k and calculate the length
	* and maintain the max length window 
	*/
	static int bruteForce(int A[], int n, int k)
	{
		int maxLen = 0;
		
		for(int i=0; i<n; i++)
		{
			 int sum = 0;
			 
			 for(int j=i; j<n; j++)
			 {
				 sum += A[j];
				 
				 if(sum == k)
					maxLen = Math.max(maxLen, j-i+1); 
			 }
		}
		
		return maxLen;
	}
	
	public static void main(String [] args)
	{
		int A[] = {-5, 8, -14, 2, 4, 12};
		int n = A.length;
		int k = -5;
		
		out.println(largestSubArray(A, n, k));
		//out.println(bruteForce(A, n, k));
	}
}