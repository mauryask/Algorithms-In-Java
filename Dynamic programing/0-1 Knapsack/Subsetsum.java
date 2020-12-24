// subset sum problem
// dynamic programming
 
import static java.lang.System.*;

public class Subsetsum 
{		
	public static void main(String [] srga)
	{
		int sub[] =  {4,3,2,7};
		int n = 4;
		int sum = 6;
		
		out.println(topDown(sub,n,sum));
	}
	
	/**
	* Recursive Approach
	* Worst Approach
	* Time Complexity : O(2^n);
	* Space Complexity : Height of the recursion tree
	*/	
		
	static boolean recursive(int sub[], int n, int sum)
	{
		if(sum == 0)
			return true;
		if(sum != 0 && n==0)
			return false;
		
		if(sum >= sub[n-1])
			return (recursive(sub,n-1,sum-sub[n-1]) || recursive(sub, n-1, sum));
		else
			return recursive(sub,n-1, sum);
	}
	
	/**
	* Bottom Up Approach (Dynamic Programming)
	* Best Approach
	* Time Complexity : O(n * sum);
	* Space Complexity : O(n * sum)
	*/	
	
	static boolean topDown(int sub[], int n, int sum)
	{
		boolean dp[][] = new boolean[n+1][sum+1];
		
		for(int i=0; i<n+1; i++)
		{
			dp[i][0] = true;
		}
		
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=1; j<sum+1; j++)
			{
				if(sub[i-1] <= j)
					dp[i][j] = dp[i-1][j-sub[i-1]] || dp[i-1][j];
				else if(sub[i-1] > j)
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return  dp[n][sum];
	}
}