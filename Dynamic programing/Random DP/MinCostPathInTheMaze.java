// https://www.geeksforgeeks.org/min-cost-path-dp-6/

import static java.lang.System.*;
import java.util.*;

public class MinCostPathInTheMaze
{
	/*
	* T(n) : O(3^(m*n))
	* S(n) : O(height of the recursion tree)
	* Exponantial time complexity
	*/
	static int minCost(int[][] cost, int m, int n, int x, int y)
	{
		if(x==m || y==m)
			return Integer.MAX_VALUE;
		if(x==m-1 && y==n-1)
			return cost[x][y];
		return cost[x][y]+ Math.min(Math.min(minCost(cost,m,n,x+1,y+1)
		, minCost(cost,m,n,x,y+1)), minCost(cost,m,n,x+1,y));
	}
	
	/*
	* T(n) : O(mn)
	* S(n) : O(mn)
	*/
	static int topDown(int[][] cost,int[][] dp,int m, int n, int x, int y)
	{
		if(x==m || y==m)
			return dp[x][y] = Integer.MAX_VALUE;
		if(x==m-1 && y==n-1)
			return dp[x][y] = cost[x][y];
		
		if(dp[x][y] != -1)
			return dp[x][y];
		
		return dp[x][y] = cost[x][y] + Math.min(Math.min(minCost(cost,m,n,x+1,y+1), 
		minCost(cost,m,n,x,y+1)), minCost(cost,m,n,x+1,y));
	}
	
	/*
	* T(n) : O(mn)
	* S(n) : O(mn)
	*/
	static void bottomUp(int cost[][], int dp[][], int m, int n)
	{
		for(int i=m-1; i>=0; i--)
		{
			for(int j=n-1; j>=0; j--)
			{
	           		if(i==m-1 && j==n-1)
						dp[i][j] = cost[i][j];
					else if(i==m-1)						 
					  dp[i][j] = cost[i][j] + dp[i][j+1];
				    else if(j==n-1)
						dp[i][j] = cost[i][j] + dp[i+1][j];
					else
						dp[i][j] = Math.min(Math.min(dp[i+1][j], 
					dp[i][j+1]),dp[i+1][j+1])+cost[i][j];
			}
		}
		
		out.println(dp[0][0]);
	}
	

     /*
	* T(n) : O(mn)
	* S(n) : O(1)
	** Idea is store the updated 
	** cost int the same array
	*/
	
	static void optimizedBottomUp(int cost[][],int m, int n)
	{
		for(int i=m-1; i>=0; i--)
		{
			for(int j=n-1; j>=0; j--)
			{
	           		if(i==m-1 && j==n-1)
						continue; // do nothing (same value)
					else if(i==m-1)
					 cost[i][j] += cost[i][j+1];
				    else if(j==n-1)
						cost[i][j] += cost[i+1][j];
					else
						cost[i][j] = Math.min(Math.min(cost[i+1][j],
					cost[i][j+1]),cost[i+1][j+1])+cost[i][j];
			}
		}
		
		out.println(cost[0][0]);
	}
	
	
	public static void main(String [] args)
	{
		int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3} };
						 int m = 3;
						 int n= 3;
		int dp[][] = new int[m][n];
		for(int x[] : dp)
			Arrays.fill(x, -1);
	    //out.println(minCost(cost, m,n,0,0));
	    //out.println(topDown(cost,dp, m,n,0,0));
		//bottomUp(cost,dp,m,n);
		optimizedBottomUp(cost,m,n);
	}
}