import static java.lang.System.*;

public class EqualSumPartition
{
	public static void main(String [] args)
	{
		int set[]  = {8,7,4,3};
		int n = 4;
		
		out.println(solve(set, n));
	}
	
	static boolean solve(int set[], int n)
	{
		int sum = 0;
		for(int i=0; i<n; i++)
			sum += set[i];
		
		if(sum % 2 != 0) //if some is not even
			return false;
			
		else //if sum is even
		   return solveUtil(set, n, sum/2);	
	}
	
	static boolean solveUtil(int set[], int n, int sum)
	{
		boolean dp[][] = new boolean[n+1][sum+1];
		for(int i=0; i<n+1; i++)
			dp[i][0] = true;
		
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<sum+1; j++)
			{
				if(set[i-1] <= j)
					dp[i][j] = dp[i-1][j-set[i-1]] || dp[i-1][j];
				else if(set[i-1] > j)
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][sum];
	}
}