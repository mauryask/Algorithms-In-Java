// here our assumption is the rat can move only in 
// vertical nad horizotal direction
// the source is (0,0)
// destination is (N-1, N-1)

import static java.lang.System.*;

public class RatMaze 
{
	int N;
	RatMaze(int N){this.N = N;}
	
	void prinMazePath(int maze[][])
	{
		int sol[][] = new int[N][N]; 
		if(!mazePathUtil(maze, 0, 0, sol))
		{
			out.println("The rat can not reach to detination!");
			return ;
		}
		
		printPath(sol);
	}
	
	boolean mazePathUtil(int maze[][], int x, int y, int sol[][])
	{
		//base condition 
		if(x == N-1 && y == N-1 && maze[x][y] == 1) //destination reached
		{
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze,x ,y))
		{
			sol[x][y] = 1;
			
			if(mazePathUtil(maze, x+1, y, sol)) //move right
				return true;
			if(mazePathUtil(maze,x ,y+1 , sol)) //move down
				return true;
				
			sol[x][y] = 0;
		}
		
		return false;
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
					  					  
	  new RatMaze(4).prinMazePath(maze);				   
   }   
}