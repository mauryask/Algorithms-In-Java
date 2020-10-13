// finding mimnimum nuber of insertion and deltion 
// to convert string a to string b
// see the video lectires for more

import static java.lang.System.*;

public class MinimumNumberOfAdditionAndSubTractoin
{
	public static void main(String [] args)
	{
		String a = "heap";
		String b = "pea";
		int m = a.length();
		int n = b.length();
		
		solve(a,b,m,n);
	}
	
	static void solve(String a, String b, int m, int n)
	{
		int dp[][] = new int[m+1][n+1];
		
		for(int i=1;i<m+1; i++)
		{
			for(int j=1;j<n+1; j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = 1+dp[i-1][j-1];
				else
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		out.println("Addtions: "+(n-dp[m][n]));
	        out.println("Deletion: "+(m-dp[m][n]));	
	}
}