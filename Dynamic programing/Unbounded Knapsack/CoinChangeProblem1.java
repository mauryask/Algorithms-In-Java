import static java.lang.System.*;

public class CoinChangeProblem1
{
	public static void main(String [] args)
	{
		int coin[] =  {1,2,3};
		int sum = 5; // 5 Rs. we want
		int n = 3;
		
		out.println(topDown(coin, n, sum));
	}
	
	static int recursive(int coin[] , int n, int sum)
	{
	  if(n == 0 && sum != 0)
		  return 0;
	  if(sum == 0)
		  return 1;
	  
	  if(coin[n-1] <= sum)
		  return recursive(coin, n, sum-coin[n-1])  + recursive(coin, n-1, sum);
	  else
		  return recursive(coin, n-1, sum);
	}
	
	static int topDown(int coin[], int n, int sum)
	{
	   int dp[][] = new int[n+1][sum+1];
       
       for(int i=0; i<n+1; i++)
			dp[i][0] = 1; 
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<sum+1; j++)
			{
				if(coin[i-1] <= j)
					dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][sum];
	}
}