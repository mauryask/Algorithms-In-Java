/**
* How many ways a set can be divided into two such subsets such that
* diferene between the sum of elements can produce the gievn value(diff)
*/

import static java.lang.System.*;

public class NumberOfSubsetswithGivenDiff
{
	public static void main(String [] args)
	{
		int set[] = {1,2,7};
		int n = set.length;
		int diff = 4;
		int sum = 0;
		for(int i=0; i<n; i++)
		sum += set[i];
	
	   // find number of substes that can produce this sum
	    int s1 = (sum + diff) / 2;
	
	    out.println(solve(set, n, s1));
	}
	
	static int solve(int set[], int n, int s) //bottom up approach
	{
		int dp[][] = new int[n+1][s+1];
		for(int i=0; i<n+1; i++)
			dp[i][0] = 1;
		
		
		for(int i=1;i<n+1; i++)
		{
			for(int j=1;j<s+1; j++)
			{
				if(set[i-1] <=  j)
					dp[i][j] = dp[i-1][j-set[i-1]] + dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][s];
	}
}