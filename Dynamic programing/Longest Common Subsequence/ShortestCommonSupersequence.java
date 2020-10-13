import static java.lang.System.*;

public class ShortestCommonSupersequence
{
	public static void main(String [] args)
	{
		String x = "AGGTAB";
		String y = "GXTXAYBK";
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
		printScs(x,y,m,n,dp);
		return dp[m][n];
	}
	
	static void printScs(String x, String y, int m, int n, int dp[][])
	{
		int i = m;
		int j = n;
		StringBuilder str = new StringBuilder();
		while(i > 0 && j > 0)
		{
			if(x.charAt(i-1) == y.charAt(j-1))
			{
				str.append(x.charAt(i-1));
	            i--;j--;				
			}
			else
			{
				if(dp[i-1][j] > dp[i][j-1])
				{
					str.append(x.charAt(i-1));
					i--;
				}
				else  //less or equal
				{
					str.append(y.charAt(j-1));
					j--;
				}
			}
		}
		
		while(i>0)
		{
			str.append(x.charAt(i-1));
			i--;
		}
		
		while(j>0)
		{
			str.append(y.charAt(j-1));
			j--;
		}
		
		out.println(str.reverse());
	}
}