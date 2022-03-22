// calculating minimum number of coins required to 
// produce the required sum
// each coin is infinite in number
// you can take as may coins as you can

/**
* Very important Question
* also see this question at leet code for 
* different inputs 
* https://leetcode.com/problems/coin-change/submissions/ 
*/

import static java.lang.System.*;

public class CoinChange2
{
	//this solution is not applicable for every test case (leet code)
	static int solve(int coin[], int sum, int n)
	{
		if(sum == 0)
			return 0;
	    if(n==0 && sum!=0)
			return Integer.MAX_VALUE-1;
		
		if(coin[n-1]<=sum)
		  return Math.min(solve(coin, sum-coin[n-1], n)+1,solve(coin, sum, n-1));	
		else
		   return solve(coin, sum, n-1);	
	}
	
	//best solution applicable for each and every test case (leet code)
	static int bottomUp(int coin[], int sum, int n)
	{
		int dp[][] = new int[n+1][sum+1];
		for(int i=1;i<sum+1; i++) //initialize(infinite is used beacause for comparison)
		  dp[0][i] = Integer.MAX_VALUE-1;
				
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<sum+1 ; j++)
			{
				if(coin[i-1] <= j)
					dp[i][j] = Math.min(1+dp[i][j-coin[i-1]], dp[i-1][j]);
				else if(coin[i-1] > j)
					dp[i][j] = dp[i-1][j];
			}
		}
		
		//important line of code (see leet code)
		return dp[n][sum] == 2147483646 || dp[n][sum] == 2147483647 ? -1 : dp[n][sum];
	}
	
    public static void main(String [] args)
	{
		int coin[] = {1,2,3,9};
		int sum = 9;
		int n = 4;
		out.println(solve(coin, sum, n));
	}
	
	
}