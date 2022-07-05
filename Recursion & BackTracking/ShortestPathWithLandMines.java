// https://www.geeksforgeeks.org/find-shortest-safe-route-in-a-path-with-landmines/

import static java.lang.System.*;
import java.util.*;

public class ShortestPathWithLandMines
{
	static int solve(int[][] grid, int x, int y, 
	int m, int n, int[][] dp)
	{
		if(!(x<m && x>=0 && y<n && y>=0 && 
		grid[x][y] != -1 && grid[x][y] != 0))
			return Integer.MAX_VALUE;
			
		if(y==n-1 && grid[x][y] == 1)
			return 1;
		
		if(dp[x][y] != -1)
			return dp[x][y];
			
	    int temp = grid[x][y];
        grid[x][y] = -1;
        int up = solve(grid, x-1, y, m, n, dp);		
        int left = solve(grid, x, y-1, m, n, dp);		
        int right = solve(grid, x+1, y, m, n, dp);		
        int down = solve(grid, x, y+1, m, n, dp);
      	grid[x][y] = temp;
		
		int min = Math.min(Math.min(up, left), 
		Math.min(right, down));
		
		return dp[x][y] = (min == Integer.MAX_VALUE)
		? min : min+1;
	}
	
	static void updateGrid(int[][] grid, int m, int n)
	{
		boolean visited[][] = new boolean[m][n];
		
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(grid[i][j] == 0 && !visited[i][j])
				{		
                    visited[i][j] = true;
					
					if(isSafe(grid, i-1, j, m, n))
					{
						grid[i-1][j] = 0;
						visited[i-1][j] = true; 
					}
					if(isSafe(grid, i, j-1, m, n))
					{
						grid[i][j-1] = 0;
						visited[i][j-1] = true;
					}
					if(isSafe(grid, i+1, j, m, n))
					{
						grid[i+1][j] = 0;
						visited[i+1][j] = true;
					}
					if(isSafe(grid, i, j+1, m, n))
					{
						grid[i][j+1] = 0;
						visited[i][j+1] = true;
					}					
				}
			}
		}
	}
	
	static boolean isSafe(int[][] grid, int x, int y, int m,int n)
	{
		return x<m && x>=0 && y<n && y>=0 && grid[x][y] != 0;
	}
	
	public static void main(String [] args)
	{
		int grid[][] = /*{
   {1, 1, 0, 1},
   {1, 1, 0, 1},
   {1, 1, 1, 1},
   {1, 1, 1, 1}
};*/{
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
		int m = grid.length;
		int n = grid[0].length;
		updateGrid(grid, m, n);
		
		for(int x[] : grid)
		{
			for(int y : x) 
				out.print(y+"         ");
			out.println("\n");
		}
		int dp[][] = new int[m][n];
		
		for(int x[] : dp)
			Arrays.fill(x, -1);
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<m; i++)
		   min = Math.min(min, solve(grid, i, 0, m, n, dp));
	   
	   out.println(min);
	}
}