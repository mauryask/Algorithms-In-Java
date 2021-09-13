// finding the longest repeting subsequencce
// in a given string 
import static java.lang.System.*;
public class LongestRepeatingSubsequences
{
	public static void main(String [] args)
	{
		String str = "AABEBCDD";
		int n = str.length();
		
		out.println(solve(str, n));
	}
	
	static int solve(String str, int n)
	{
		int dp[][] = new int[n+1][n+1];
		
		for(int i=1;i<n+1; i++)
		{
			for(int j=1;j<n+1; j++)
			{
				if(str.charAt(i-1) == str.charAt(j-1) && i!=j)
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		printSeq(str, n, dp);
		
		return dp[n][n];
	}
	
	
	/*
	* Just take the same string as 2nd string
	* and find longest common subsequence
	* with a small modification 
	* that i!=j, since they are same strings
	*/
	static void printSeq(String str, int n, int dp[][])
	{
		int i= n;
		int j= n;
		StringBuilder sb = new StringBuilder();
		while(i > 0 && j > 0)
		{
			if(str.charAt(i-1) == str.charAt(j-1) && i!=j)
			{
			    sb.append(str.charAt(i-1));	
				i--;
				j--;
			}
			else
			{
				if(dp[i-1][j] > dp[i][j-1])
					i--;
				else
					j--;
			}
		}
		
		out.println(sb.reverse());
	}
}