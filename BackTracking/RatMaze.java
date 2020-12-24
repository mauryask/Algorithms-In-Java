// here our assumption is the rat can move only in 
// vertical nad horizotal direction
// the source (0,0)
// destination is (N-1, N-1)

// here we just only want to check (return true and false)
// is there any path form source to
// destination
// if yes then print it
// print only one does not 
// matter how may paths are there 


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
					   {1,0,0,1}};
	  int row = 0;
      int col = 0;
	  
	  int m = 4; // total rows
	  int n = 4; // total columns
	  
	  boolean status = new RatMaze(m,n).mazePathUtil(maze, row, col);	
      out.println(status);	  
   }   
}