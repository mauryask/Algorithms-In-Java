// https://leetcode.com/problems/climbing-stairs/submissions/
import static java.lang.System.*;
import java.util.*;

public class StiarCaseProblem
{
	public static void main(String [] args)
	{
		    int n = 4;
			int m = 2;
		    int dp[] = new int[n+1];
			
			// for topDown approach 
			/*
			 for(int i=0; i<n+1; i++)
			   dp[i] = -1;
			*/
			
			out.print(solve(n,m,dp));
	}
	
	static int recursive(int n, int m, int dp)
	{
		if(n==0 || n==1)
			return n;
		if(n<=m)
			return 1 + recursive(n-1, m, dp) + recursive(n-2,m,dp);
		else
			return recursive(n-1, m, dp) + recursive(n-2, m, dp);
	}
	
	static int topDown(int n, int m, int dp[])
	{
		if(n==0 || n==1)
			return n;
		
		if(dp[n] != -1)
			return dp[n];
		
		if(n<=m)
			return dp[n] = 1 + topDown(n-1, m, dp) + topDown(n-2, m, dp);
		else
			return dp[n] = topDown(n-1, m, dp) + topDown(n-2, m, dp);
	}
	
	static int bottomUp(int n, int m, int dp[])
	{
	    dp[0] = 0;
		dp[1] = 1; 
		
		for(int i=2;i<n+1;i++)
		{
			if(i>1 && i<=m)
				dp[i] = dp[i-1] + dp[i-2] + 1;
			else
				dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
}