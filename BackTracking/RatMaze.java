// here our assumption is the rat can move only in 
// vertical nad horizotal direction
// the source s (0,0)
// destination is (N-1, N-1)

import static java.lang.System.*;

public class RatMaze 
{
	int N;
	RatMaze(int N){this.N = N;}
	
	void prinMazePath(int maze[][], int x, int y)
	{
		int sol[][] = new int[N][N]; 
		boolean status = false;
		status = mazePathUtil(maze, x, y, status, sol);
		if(!status)
			out.println("No path found");			
	}
	
	boolean mazePathUtil(int maze[][], int x, int y, boolean status, int sol[][])
	{
		//base condition 
		if(x == N-1 && y == N-1 && maze[x][y] == 1) //destination reached
		{
			sol[x][y] = 1;
			status = true;
			printPath(sol); //print path
			return status;
		}
		
		sol[x][y] = 1;
			
		if(isSafe(maze,x ,y))
		{
			if(x+1<N) //move right
				status = mazePathUtil(maze, x+1, y, status, sol);
			if(y+1<N) //move down
				status = mazePathUtil(maze,x ,y+1 , status, sol);
						
		}
		sol[x][y] = 0;	
		
		return status;
	}
	
	boolean isSafe(int maze[][], int x, int y)
	{
		if(x>=0 && y>=0 && x<N && y<N && maze[x][y] == 1)
			return true;
		return false;
	}
	
	void printPath(int sol[][])
	{
		for(int i=0;i<N; i++)
		{
			for(int j=0;j<N;j++)
			{
				out.print(sol[i][j]+" ");
			}
			out.println();
		}
	}
	
   public static void main(String args[])
   {
	   int maze[][] = {{1,1,0,0},
					   {0,1,0,0},
					   {1,1,1,0},
					   {0,0,1,1}};
					  					  
	  new RatMaze(4).prinMazePath(maze,0,0);				   
   }   
}