/*
* T(n) : O(2^N)
* S(n) : O(mxn)
*****
** Don't need visited here
** since we are moving only in right 
** and downward directions
*/

import static java.lang.System.*;

public class RatMaze 
{
	int n;
	int m;
	int sol[][];
	static int count = 0;
	
	RatMaze(int m, int n)
	{
		this.n = n;
		this.m = m;
		sol = new int[m][n];
	}
	
	void mazePathUtil(int maze[][], int row, int col)
	{
		if(row == m-1 && col == n-1 && maze[row][col] == 1) 
		{
			sol[row][col] = 1;
			count++;
			printPath(sol);
		}
	
		if(isSafe(maze ,row ,col))
		{
			sol[row][col] = 1;
			
			//move down			
			mazePathUtil(maze ,row+1 ,col);
			//move right
		    mazePathUtil(maze, row, col+1);
				
		    sol[row][col] = 0;	
		}
	}
	
	boolean isSafe(int maze[][], int row, int col)
	{
		return row>=0 && col>=0 && row < m &&
		col < n && maze[row][col] == 1;
	}
	
	void printPath(int sol[][])
	{
		for(int[] x: sol)
		{
			for(int y : x)
				out.print(y+" ");
			out.println();
		}
		out.println();
	}
	
   public static void main(String args[])
   {
	  int maze[][] =  {{1,1,1,1},
					   {0,1,0,1},
					   {1,1,1,1},
					   {1,0,0,1}};
			   
	  int row = 0;
      int col = 0;
	  
	  int m = 4;
	  int n = 4;
	  
	  new RatMaze(m,n)
	  .mazePathUtil(maze, row, col);	
	  
	  out.println(count);
   }   
}

/*
** printing onle one path  
** if availabale

	void mazePathUtil(int maze[][], int row, int col)
	{
		if(row == m-1 && col == n-1 && maze[row][col] == 1) 
		{
			sol[row][col] = 1;
			printPath(sol);
			return true;
		}
	
		if(isSafe(maze ,row ,col))
		{
			sol[row][col] = 1;
			
			//move down			
			if(mazePathUtil(maze ,row+1 ,col))
			   return true;
			//move right
		    if(mazePathUtil(maze, row, col+1))
				return true;
				
		    sol[row][col] = 0;	
		}
		
		return false;
	}
*/