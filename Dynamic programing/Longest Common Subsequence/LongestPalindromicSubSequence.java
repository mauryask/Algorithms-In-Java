// Longest Palindromic Subsequence
/**
* One more question is derived from here
* --> minimum number of deletions to meke string palindromic subsequence (LPS)
* just find the logest palindromic subsequence 
* and the check the length of this subsequence
* find difference between original and this string
* it will give you the minimum number of deletions 
* to make a string LPS
*/
import static java.lang.System.*;

public class LongestPalindromicSubSequence
{
	public static void main(String [] args)
	{
	   String str = "agbcba";
	   String rstr = new StringBuilder(str).reverse().toString();
	   out.println(solve(str, rstr, str.length()));
  	}
	
	static int solve(String a, String b, int n)
	{
		int dp[][] = new int[n+1][n+1];
		
		for(int i=1;i<n+1; i++)
		{
			for(int j=1;j<n+1; j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[n][n];
	}
}