import static java.lang.System.*;
import java.util.*;

public class MatrixChainMultiplication 
{
	public static void main(String [] args)
	{  
	   int p[] =  new int[]{40, 20, 30, 10, 30, 80, 47, 45, 78, 41, 12, 23, 74, 89, 23, 52};
	   int n = p.length - 1;
	   int dp[][] = new int[n][n];
	   
	   for(int[] x: dp)
	   {
		   Arrays.fill(x,-1);
	   }
	   
	   // cost of multiplying from "0 to n-1"
	   out.println(topDown(p,dp,0,n-1));
	}
	
	
	// Recursive solution
	// Time Complexity : O(2^n)
	// Space Complexity: O(n) --> depth of recursion tree
	
	static int recursive(int p[], int i, int j)
	{
		if(i==j)
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int k=i; k<j; k++)
		{
			min =  Math.min(min, recursive(p,i,k) 
			+ recursive(p,k+1,j)
			+ p[i] * p[k+1] * p[j+1]);
		}
		
		return min;
	}
	
	// Top Down Approach
	// Time Complexity : O(n^3)
	// Space Complexity: O(n) --> depth of recursion tree
	
	static int topDown(int p[], int dp[][], int i,int j)
	{
		if(i==j)
			return 0;
				
		if(dp[i][j] != -1)
			return dp[i][j];
		
		dp[i][j] = Integer.MAX_VALUE;
		
		for(int k=i; k<j; k++)
		{
			dp[i][j] = Math.min(dp[i][j], 
			topDown(p,dp,i,k) 
			+ topDown(p,dp,k+1,j)
			+ p[i]*p[k+1]*p[j+1]);
		}
		
		return dp[i][j];
	}
	
	// Bottom Up approach
	// Best Approach
	// Time Complexity: O(n^3)
	// Space Complexity : O(n^n);
	
	static int bottomUp(int p[], int n)
	{
		int dp[][] = new int[n][n];
		
		for(int i=0;i<n; i++)
			dp[i][i] = 0;
		
		
		for(int l=2; l<=n; l++)
		{
			for(int i=0; i<n-l+1; i++)
			{
				int j = i+l-1;
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int k=i; k<j; k++)
				{
					dp[i][j] = Math.min(dp[i][j], 
					dp[i][k]+dp[k+1][j] + p[i]*p[k+1]*p[j+1]);
				}
			}
		}
		
		return dp[0][n-1];
	}
 }
