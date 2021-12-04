import static java.lang.System.*;
import java.util.*;

public class LongestPalindromicSubstring
{
	// Bruteforce solution
	// T(n) : O(n^3)
	// S(n) : O(1)
	
	static int lps(String str,int n)
	{
		int maxLength  = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++)
		{
			for(int j=i; j<n; j++)
			{
				int start = i;
				int end = j;
				boolean flag = true;
				
				while(start < end)
				{
					if(str.charAt(start) != str.charAt(end))
					{
						flag = false;
						break;
					}
					
					start++;
					end--;
				}
				
				if(flag)
					maxLength = Math.max(maxLength, j-i+1);
			}
		}
		
		return maxLength;
	}
	
	
	// Using dynamic programming 
	// T(n) : O(n*n)
	// S(n) : O(n*n)
	
	static int lps2(String str, int n)
	{
		int dp[][] = new int[n+1][n+1];
		String revStr = "";
		
        for(int i=0; i<n; i++)		
		  revStr =  str.charAt(i) + revStr;
	    
		int maxLength = Integer.MIN_VALUE;
		
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(str.charAt(i-1) == revStr.charAt(j-1))
				{
					dp[i][j] = 1 + dp[i-1][j-1];
					
					maxLength = Math.max(dp[i][j], maxLength);
				}
				else
					dp[i][j] = 0;
			}
		}
		
		return maxLength;
	}
	
	public static void main(String [] args)
	{
		String str = "forgeeksskeegfor";
		int n = str.length();
		
		//out.println(lps(str, n));
		out.println(lps2(str, n));
	}
}