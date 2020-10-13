// to find minimum number of insertion 
// we can find Longest Palindromic SubSequence
// and then find the differene between LPS and the original string 
// this will be the minimum number of insertions

import static java.lang.System.*;

public class MinimumInsertionToMakePalindrome
{
	public static void main(String [] args)
	{
		String x = "ACBCBDA";
		String y = new StringBuilder(x).reverse().toString();
		int n =  x.length();
		out.println(solve(x, y, n));
	}
	
	static int solve(String x, String y, int n)
	{
		int dp[][] = new int[n+1][n+1];
		
		for(int i=1;i<n+1; i++)
		{
			for(int j=1;j<n+1; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return n - dp[n][n]; 
	}
}