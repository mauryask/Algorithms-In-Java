/**
* How many different ways are there we can assign either
*  +ve or -ve to each element to produce the given sum(taget sum)
*/

import static java.lang.System.*;

public class TargetSum 
{
	public static void main(String [] args)
	{
		int set[] = {1,2,4,7,8};
		int target_sum = 16;
		int n = set.length;
		int sum = 0;
		for(int i=0;i<n; i++)
			sum+=set[i];
		
		int t_sum = (sum +target_sum)/2;
		
		out.println(solve(set, n, t_sum));
	}
	
	static int solve(int set[], int n, int s) //bottom up approach
	{ 
		int dp[][] = new int [n+1][s+1];
		
		for(int i=0;i<n+1; i++)
			dp[i][0] = 1;
		
		for(int i=1;i<n+1; i++)
		{
			for(int j=1;j<s+1; j++)
			{
				if(set[i-1] <= j)
					dp[i][j] = dp[i-1][j-set[i-1]] + dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][s];
	}
}