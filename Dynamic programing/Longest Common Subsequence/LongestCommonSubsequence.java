// all the three approaches to find
// length of the longest common subsequences
import static java.lang.System.*;

public class LongestCommonSubsequence
{
	static int dp[][];

	public static void main(String [] args)
	{
		String x = "abcdef";
		String y = "bcdfe";
		int m = x.length();
		int n = y.length();
				
		dp = new int[m+1][n+1];
		// for bottom up (memoization)
		/*for(int i=0;i<m+1; i++)
		{
			for(int j=0;j<n+1; j++)
				dp[i][j] = -1;
		}
		*/
		out.println(topDown(x,y,m,n,dp));
  	}
	
	static int recursive(String x, String y,int m, int n)
	{
		if(m == 0 || n == 0)
			return 0;
		
		if(x.charAt(m-1) == y.charAt(n-1))
			return 1+recursive(x, y, m-1, n-1);
		else
		{
			return Math.max(recursive(x,y,m-1,n), recursive(x,y,m,n-1));
		}
	}
	
	static int memoization(String x, String y, int m, int n)
	{
		if(m==0 || n==0)
			return 0;
		if(dp[m][n] != -1)
			return dp[m][n];
		
		if(x.charAt(m-1) == y.charAt(n-1))
			return dp[m][n]= 1+memoization(x , y, m-1, n-1);
		else
		{
			return dp[m][n] = Math.max(memoization(x, y, m-1, n), 
			memoization(x, y, m, n-1));
		}
	}
	
	static int topDown(String x, String y, int m, int n, int dp[][])
	{
	 
/*	 for(int i=0; i<m+1; i++)
	    dp[i][0] = 0;
	  for(int j=1; j<n+1; j++)
		  dp[0][j] = 0;
	  */
	  
	  
	  for(int i=1; i<m+1; i++)
	  {
		  for(int j=1;j<n+1; j++)
		  {
			  if(x.charAt(i-1) == y.charAt(j-1))
				  dp[i][j] = 1 + dp[i-1][j-1];
			  else
			  {
				  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			  }
		  }
	  }
	  return dp[m][n];
	}
}