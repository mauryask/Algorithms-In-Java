// here our assumption is the rat can move only in 
// down and right direction
// the source (0,0)
// destination is (m-1, n-1)

// here we just only want to check (true/false)
// is there any path form source to
// destination
// if yes then print it
// print only one does not 
// matter how may paths are there 


// is you eant to print 
// all the paths then check all path 
// problem source code

import static java.lang.System.*;

public class RatMaze 
{
	int n;
	int m;
	int sol[][];
	
	RatMaze(int m, int n)
	{
		this.n = n;
		this.m = m;
		sol = new int[m][n];
	}
	
	boolean mazePathUtil(int maze[][], int row, int col)
	{
		if(row == m-1 && col == n-1 && maze[row][col] == 1) 
		{
			sol[row][col] = 1;
			printPath(sol);
			return true;
		}
		
		sol[row][col] = 1;

		if(isSafe(maze ,row ,col))
		{
			if(col+1 < n) //move right
			   return  mazePathUtil(maze, row, col+1); 
			if(row+1 < m) //move down
				return mazePathUtil(maze ,row+1 ,col);
		}
		
		sol[row][col] = 0;	
		
		return false;
	}
	
	boolean isSafe(int maze[][], int row, int col)
	{
		return row>=0 && col>=0 && row < m && col < n && maze[row][col] == 1;
	}
	
	void printPath(int sol[][])
	{
		out.println("\n****************\n");
		for(int[] x: sol)
		{
			for(int y : x)
				out.print(y+" ");
			out.println();
		}
	}
	
   public static void main(String args[])
   {
	  int maze[][] =  {{1,1,1,1},
					   {0,1,0,1},
					   {1,1,1,1},
					   {1,0,0,0}};
	  int row = 0;
      int col = 0;
	  
	  int m = 4;
	  int n = 4;
	  
	  boolean status = new RatMaze(m,n).mazePathUtil(maze, row, col);	
      out.println(status);	  
   }   
}