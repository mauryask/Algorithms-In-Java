// calculating minimum number of cpoins required to 
// produce the required sum
// each coin is infinite in number
// you can take as may coins as you can

import static java.lang.System.*;
public class CoinChain2
{
	public static void main(String [] args)
	{
		int coin[] = {1,2,3,4};
		int sum = 4;
		int n = 4;
		out.println(topDown(coin, sum, n));
	}
	
	static int solve(int coin[], int sum, int n)
	{
		if(sum == 0)
			return 0;
	    if(n==0 && sum!=0)
			return Integer.MAX_VALUE;
		
		if(coin[n-1]<=sum)
			return (int)Math.min(solve(coin, sum-coin[n-1], n)+1,solve(coin, sum, n-1));
		else
			return solve(coin, sum, n-1);
	}
	
	static int topDown(int coin[], int sum, int n)
	{
		int dp[][] = new int[n+1][sum+1];
		for(int i=1;i<sum+1; i++) ///initialize(infinite is used beacause for comparison)
			dp[0][i] = Integer.MAX_VALUE;
		
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<sum+1 ; j++)
			{
				if(coin[i-1] <= j)
					dp[i][j] = (int)Math.min(1+dp[i][j-coin[i-1]], dp[i-1][j]);
				else if(coin[i-1] > j)
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[n][sum];
	}
}