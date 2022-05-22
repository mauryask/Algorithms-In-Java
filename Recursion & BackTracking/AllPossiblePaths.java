/*
* T(n) : O(4^m*n)
* S(n) : O(mxn)
**********
** We do need visited array here 
** Since we are moving checking 
** in top and left cells 
** hence we can endup checking in same cells 
** multiple times 
*/

import static java.lang.System.*;
import java.util.*;

public class AllPossiblePaths
{
    int m, n;
	int sol[][];
	boolean visited[][];
	static int count = 0;
	
	AllPossiblePaths(int m, int n)
	{
		this.m = m;
		this.n = n;
		visited = new boolean[m][n];
		sol = new int[m][n];
	}
	
	void allPath(int maze[][], int row, int col)
	{
		if(row == m-1 && col == n-1 && maze[row][col] == 1)
        {
			count++;
			sol[row][col] = 1;
			printSol();
			return;
		}			
		
        // if it is safe then 
		// only go to that cell		
		
		if(isSafe(maze, row, col))
		{
		     sol[row][col] = 1;
		     visited[row][col] = true;
			 
			//move up
				allPath(maze, row-1, col);			
			//move down
				allPath(maze, row+1, col);
			//move left
				allPath(maze, row, col-1);					
			//move right
				allPath(maze, row, col+1);
			 
			 sol[row][col] = 0;
		     visited[row][col] = false;
		}
	}
	
	boolean isSafe(int maze[][], int  row, int col)
	{
		return row < m && row>=0 && col < n 
		&& col >=0 && maze[row][col]==1 && !visited[row][col]; 
	}
	
	void printSol()
	{
		for(int A[] : sol)
		{
			for(int x : A)
			   out.print(x+" ");
		   out.println();
		}
			
		out.println("\n========\n");
	}
	
	public static void main(String [] args)
	{
		int maze[][] = {{1,0,1,1},
			            {1,1,0,1},
						{0,1,1,1},
						{1,0,1,1}};
		int row = 0;
		int col = 0;
		
		int m = 4; // total row 
		int n = 4; // total col
		
	    new AllPossiblePaths(m,n).allPath(maze,row,col);
		out.println(count);
	}
 }

/*
** Checking for only one path 
** whether available or not
    
	boolean allPath(int maze[][], int row, int col)
	{
		if(row == m-1 && col == n-1 && maze[row][col] == 1)
        {
			sol[row][col] = 1;
			printSol();
			return true;
		}			
			
		if(isSafe(maze, row, col))
		{
		     sol[row][col] = 1;
		     visited[row][col] = true;
			 
			//move up
				if(allPath(maze, row-1, col))
                    return true;					
			//move down
				if(allPath(maze, row+1, col))
					return true;
			//move left
				if(allPath(maze, row, col-1))
					return true;		
			//move right
				if(allPath(maze, row, col+1))
					return true;
			 
			 sol[row][col] = 0;
		     visited[row][col] = false;
		}
		
		return false;
	}

*/