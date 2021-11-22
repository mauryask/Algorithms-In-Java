// all the three approaches to find
// length of the longest common subsequences

import static java.lang.System.*;

public class LongestCommonSubsequence
{
	static int dp[][];

	public static void main(String [] args)
	{
		String x = "ecfbefdcfca";
		String y = "badfcbebbf";
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
		out.println("The length of the LCS: "+bottomUp(x,y,m,n,dp));
  	}
	
	static int recursive(String x, String y,int m, int n)
	{
		if(m == 0 || n == 0)
			return 0;
		
		if(x.charAt(m-1) == y.charAt(n-1))
			return 1+recursive(x, y, m-1, n-1);
		else
			return Math.max(recursive(x,y,m-1,n), recursive(x,y,m,n-1));
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
	
	static int bottomUp(String x, String y, int m, int n, int dp[][])
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
				  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		  }
	  }
	  
	  printSubsequence(dp,m,n,x,y); //print LCS
	  
	  for(int i=0; i<m+1; i++)
	  {
		  for(int j=0; j<n+1; j++)
			  out.print(dp[i][j] +" ");
		  out.println();
	  }
	  
	  return dp[m][n];
	}
	
	// Printing longest common subsequence
	static void printSubsequence(int dp[][],int n1, int n2, String x, String y)
	{
		String s = "";
		while(n1>0 && n2>0)
		{
			if(x.charAt(n1-1) == y.charAt(n2-1))
			{
				s = x.charAt(n1-1) + s;
				n1--; n2--;
			}
			else
			{
				if(dp[n1-1][n2] > dp[n1][n2-1])
					n1--;
				else
					n2--;
			}
		}
		
		out.println(s);
	}
}