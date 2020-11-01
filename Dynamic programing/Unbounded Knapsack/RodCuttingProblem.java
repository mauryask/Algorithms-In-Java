// Rod cutting problem 
// Unbounded knapsack problem
// both has same code
// actually rod cutting problem is basically
// unbounded knapsack problem itself

import static java.lang.System.*;

public class RodCuttingProblem
{
	public static void main(String [] args)
	{
		int length[] = {1,2,3};
		int profit[] = {2,6,4};
		int l = 3; //length of the rod
		int n = 3; //number of items (total length array size)
		
       //this is for recursive program
        int dp[][] = new int[n+1][l+1];		
		for(int i=0; i<=n; i++)
		{
			for(int j=0;j<=l; j++)
			{
				dp[i][j] = -1;
			}
		}
		
		out.println(recursive(length, profit, n, l));
	}

	
	static int recursive(int length[], int profit[], int n, int l)
	{
		if(n==0 || l==0) // if length of rod 0 or size of the length array is 0
			return 0;
			
		if(length[n-1] <= l)
		  return (int) Math.max(profit[n-1] + recursive(length, profit, n, l-length[n-1]),
					recursive(length, profit, n-1,l));
		else 
			return recursive(length, profit, n-1, l);
	}
	
	static int topDown(int length[], int profit[], int n, int l)
	{
		int dp[][] = new int[n+1][l+1];
/*
        for(int i=0;i<n+1; i++)
			dp[i][0] = 0;
		for(int i=0;i<n+1; i++)
			dp[0][i] = 0;
*/
        for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(length[i-1] <= j)
					dp[i][j] = Math.max(profit[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
	            else
					dp[i][j] = dp[i-1][j];
    		}
		}
 	
		return dp[n][l];
	}
}