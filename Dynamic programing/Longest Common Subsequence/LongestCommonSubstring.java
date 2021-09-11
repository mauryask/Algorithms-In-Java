// https://www.youtube.com/watch?v=UZRkpGk943Q
// Longest Common Substring 
// This problem best explained here

import static java.lang.System.*;

public class LongestCommonSubstring
{
	public static void main(String [] args)
	{
		String x = "bcdaef";//"ABCKKHPACDPKL";
		String y = "daef";//"ABCKKHAACDPKL";
		
		int m = x.length();
		int n = y.length();
		
		out.println(bottomUp(x, y, m, n));
		//out.println(recursive(x, y, m, n, 0));
	}
	
	// Very Important
	/* Recursive Equation
	* 0 ; m=0 || n=0
	* LCS(m-1, n-1, result+1) ; Xm = Ym
	* Max(LCS(m-1, n, 0), LCS(m, n-1, 0), result) ; Xm != Yn
	*/
	
	static int recursive(String x, String y, int m,
	int n, int result)
	{
		if(m==0 || n == 0)
			return result;
		
		if(x.charAt(m-1) == y.charAt(n-1))
			return recursive(x, y, m-1, n-1, result+1);
		else
			return Math.max(Math.max(recursive(x, y, m-1, n, 0), 
		recursive(x, y, m, n-1, 0)), result);
	}
	
	static int bottomUp(String x, String y, int m, int n)
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
				 
				 // update the length
				 // and last character location
				 // of the LCS
				 
				 if(max < result)
				 {
					max = result;
					n1 = i; //s1
					n2 = j; //s2
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
	
	static void printResult(int dp[][], 
	int m, int n, String x, String y)
	{
	    String s = "";
		
	 	while(dp[m][n] != 0)
		{
		   if(x.charAt(m-1) == y.charAt(n-1))
		   {
			   	s =  x.charAt(m-1) + s;
				m--;
				n--;
		   }
		}
		
		out.println(s);
	}
}