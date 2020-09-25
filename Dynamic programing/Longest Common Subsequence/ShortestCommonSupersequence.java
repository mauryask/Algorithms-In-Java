import static java.lang.System.*;

public class ShortestCommonSupersequence
{
	public static void main(String [] args)
	{
		String x = "AGGTAB";
		String y = "GXTXAYB";
		int m = x.length();
		int n = y.length();
		
		out.println(m+n-LCS(x,y,m,n));
	}
	
	static int LCS(String x, String y, int m , int n)
	{
		int dp[][] = new int[m+1][n+1];
		
		/*for(int i=0;i<m+1; i++)
			dp[0][i] = 0;
		for(int i=0;i<n+1; i++)
			dp[i][0] = 0; */
		
		for(int i=1;i<m+1; i++)
		{
			for(int j=1;j<n+1; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		return dp[m][n];
	}
}