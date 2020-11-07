// here our assumption is the rat can move only in 
// vertical nad horizotal direction
// the source s (0,0)
// destination is (N-1, N-1)

import static java.lang.System.*;

public class RatMaze 
{
	int N;
	int M;
	RatMaze (int M, int N)
	{
		this.N = N;
		this.M = M;
	}
	
	void prinMazePath(int maze[][], int row, int col)
	{
		int sol[][] = new int[N][N]; 
		boolean status = mazePathUtil(maze, row, col,sol);
		if(!status)
			out.println("No path found");
		else
			out.print(status);
	}
	
	boolean mazePathUtil(int maze[][], int row, int col,int sol[][])
	{
		//base condition 
		if(row == M-1 && col == N-1 && maze[row][col] == 1) //destination reached
		{
			sol[row][col] = 1;
			printPath(sol); //print path
			return true;
		}
		
		sol[row][col] = 1;
		boolean res = false; 
		
		if(isSafe(maze ,row ,col))
		{
			if(col+1 < N) //move right
				//if(mazePathUtil(maze, row, col+1,sol)) return true;
				res = mazePathUtil(maze, row, col+1,sol); 
			if(row+1 < M) //move down
				//if(mazePathUtil(maze ,row+1 ,col , sol)) return true;
				res = mazePathUtil(maze ,row+1 ,col , sol);
		}
		
		sol[row][col] = 0;	
		
		return res;
	}
	
	boolean isSafe(int maze[][], int row, int col)
	{
		if(row>=0 && col>=0 && row < M && col < N && maze[row][col] == 1)
			return true;
		return false;
	}
	
	void printPath(int sol[][])
	{
		out.println("\n****************\n");
		for(int[] x: sol)
		{
			for(int y : x)
			{
				out.print(y+" ");
			}
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
	  new RatMaze (4,4).prinMazePath(maze, row, col);				   
   }   
}