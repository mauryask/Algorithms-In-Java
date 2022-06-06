// https://leetcode.com/problems/perfect-squares/
/*
* T(n): O(n*n)
* S(n): O(n)
*/

import static java.lang.System.*;
import java.util.*;

public class PerfectSquares
{	
    static int minSqureSum(int n)
	{
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++)
		{
			int min = Integer.MAX_VALUE;
			
			for(int j=1; j*j<=i; j++)
			{
				int rem = i - j*j;				
			    min = Math.min(min, dp[rem]);	
			}
			
			dp[i] = min+1;
		}
		
		return dp[n];
	}
	public static void main(String [] args)
	{
		int n = 12;
		out.println(minSqureSum(n));
    }
}