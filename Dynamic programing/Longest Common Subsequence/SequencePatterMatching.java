// check if strign x is subsequence of string y

import static java.lang.System.*;
public class SequencePatterMatching
{
	public static void main(String [] args)
	{
		String x = "AXY";
		String y = "ABXCZY";
		int m = x.length();
		int n = y.length();
		
		out.println(solve(x, y, m, n));
	}
	
	static boolean solve(String x, String y, int m, int n)
	{
		int dp[][] = new int[m+1][n+1];
		
		for(int i=1;i<m+1; i++)
		{
			for(int j=1;j<n+1; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
			return dp[m][n] == m ? true : false;
	}
}