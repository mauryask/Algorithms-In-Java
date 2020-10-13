// 0-1 Knapsack problem
// dynmic programming standard problem

import static java.lang.System.*;

public class Knapsack 
{
	static int dp[][] = new int[4][9];
	public static void main(String [] args)
	{
		int wt[] = {2,3,4};
		int val[] = {12,16,13};
		int n = 3;
		int w = 8;
		
		/**
		* Initialization for memoization
		* initialize each entry with "-1"
		*/
		
		/*
		for(int i=0; i<n+1; i++)
		{
			for(int j=0; j<w+1; j++)
				dp[i][j] = -1;
		}
		*/
		
		
		out.println(recursive(wt, val, w, n));
		out.println(memoization(wt, val, w, n));
		out.println(bottomUp(wt, val, w, n));
	}
	
	
	/**
	* Recursive Approach
	* The worst approach
	* Time complexity : o(n^2) >> exponenetial time complexity
	* Space complexity : O(n^2)
	*/
	
	static int recursive(int wt[], int val[], int w, int n)
	{
		if(n==0 || w==0)
			return 0;
		if(wt[n-1] <= w)
			return Math.max(val[n-1] + recursive(wt, val, w-wt[n-1], n-1),
			       recursive(wt, val, w, n-1));
		else //if(wt[n-1] > w)
			return recursive(wt, val, w, n-1);
	}
	
	/**
	* Memoization (Top Down Approach)
	* Good but not best
	* Time complexity : o(n*w) >> exponenetial time complexity
	* Space complexity : O(n*w) + size of recursion stack
	*/
	
	static int memoization(int wt[], int val[], int w, int n)
	{	
		if(n==0 || w==0)
			return 0;
		
		if(dp[n][w] != 0) //check if solution already present
			return dp[n][w];
	    
		if(wt[n-1] <= w)
			return dp[n][w] = (int)Math.max(val[n-1]+memoization(wt, val, w-wt[n-1], n-1),
		                     memoization(wt, val, w, n-1));
		else 
			return dp[n][w] =  memoization(wt, val, w, n-1);	
	}
	
	/**
	* Memorization (Bottom Up) Approach
	* The best approach
	* Time complexity : o(n*w) >> exponenetial time complexity
	* Space complexity : O(n*w) 
	*/
	
	static int bottomUp(int wt[], int val[], int w, int n)
	{
		//initializzation
		/*for(int i=0; i<n+1; i++)
			dp[i][0] = 0;
		for(int j=1; j<w+1; j++)
			dp[0][j] = 0;*/
		
		for(int i=1; i<n+1; i++) //items
		{
			for(int j=1; j<w+1; j++) //weights
			{
				if(wt[i-1] <= j)
					dp[i][j] = (int)Math.max(val[i-1] + dp[i-1][j-wt[i-1]],
				               dp[i-1][j]);
				else if(wt[i-1] > w)
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[n][w];
	}
}