// https://www.youtube.com/watch?v=UZRkpGk943Q
// Longest Common Substring 
// This problem best explained here

import static java.lang.System.*;

public class LongestCommonSubstring
{
	public static void main(String [] args)
	{
		String x = "ABCKKHPACDPKL";
		String y = "ABCKKHAACDPKL";
		int m = x.length();
		int n = y.length();
		
		out.println(solve(x, y, m, n));
	}
	
	static int solve(String x, String y, int m, int n)
	{
		int dp[][] = new int[m+1][n+1];
		
		/*for(int i=0; i<m+1; i++)
		 dp[0][i] = 0;
		for(int j=1; j<n+1; j++)
	     dp[j][0] = 0; */
	 
	   int result = 0;
	   int max = 0;
	   int n1 = 0, n2 = 0;
		   
	 for(int i=1;i<m+1; i++)
	 {
		 for(int j=1;j<n+1; j++)
		 {
			 if(x.charAt(i-1) == y.charAt(j-1))
			 {
				 dp[i][j] = dp[i-1][j-1] + 1; //add 1 to diagonal element
				 result = dp[i][j];
				 if(max < result)
				 {
					max = result;
					n1 = i-1; //s1
					n2 = j-1; //s2
				 }
			 }
			 else
				 dp[i][j] = 0;
		 }
	 }
	 printResult(dp, n1, n2, x, y);
	 return max;
	}
	
	// Printing longest common substring
	static void printResult(int dp[][], int n1, int n2, String x, String y)
	{
	    StringBuilder sb = new StringBuilder();
	 	while(n1 >= 0 && n2 >=0)
		{
		   if(x.charAt(n1) != y.charAt(n2))
		    break;
		   else
			  sb.append(x.charAt(n1));
			n1--;
			n2--;
		}
		
		out.println(sb.reverse());
	}
}