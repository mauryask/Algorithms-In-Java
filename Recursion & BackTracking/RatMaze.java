/*
* Here rat can move only in 
* down and right directions
* the source (0,0)
* destination is (m-1, n-1)
*/

/* 
* We only just want to check (true/false)
* is there any path form source to
* destination o not
* if yes then print it
* print only one does not 
* matter how may available
*/

/*
* T(n) : O(m*n)
* S(n) : O(m*n)
*/

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
			/*
			* Here it is cumpulsory to use 
			* col and row index verification
			* else we will get outOfBounds in sol array
			*/
			
			/*
			* If path found then true will be returned
			* and when if condition becomes true
			* return true and no more function call for 
			* down
			*/
			
			//move right
			if(col+1 < n && mazePathUtil(maze, row, col+1)) 
			   return  true; 
			
			/* 
			* if above is true control will never go down
			* hence no more function call
			*/
			
			//move down
			if(row+1 < m && mazePathUtil(maze ,row+1 ,col)) 
				return true;
			return false;
		}
		
		sol[row][col] = 0;	
		
		return false;
	}
	
	/*
	* Check if a move is valid or not
	*/
	
	boolean isSafe(int maze[][], int row, int col)
	{
		return row>=0 && col>=0 && row < m &&
		col < n && maze[row][col] == 1;
	}
	
	/*
	* Print Path
	*/
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
					   
	  /*
	  * Source
	  */				   
	  int row = 0;
      int col = 0;
	  
	  int m = maze.length;
	  int n = maze[0].length;
	  
	  boolean status = new RatMaze(m,n)
	  .mazePathUtil(maze, row, col);	
	  
      out.println(status);	  
   }   
}