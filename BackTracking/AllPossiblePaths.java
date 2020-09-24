// this problem demonstrates how to print
// find all the possible paths from a giove source to destination
// in a maze

import static java.lang.System.*;

public class AllPossiblePaths
{
	int N;
	AllPossiblePaths(int N){this.N = N;}
	
   void totalPath(int maze[][], int x, int y)
   {
	   int count = 0;
	   boolean visited[][] = new boolean[N][N];
	   int sol[][] = new int[N][N];
	   count = pathUtil(maze, x, y, count, visited, sol);
	   out.println(count);
   }

   int pathUtil(int maze[][], int x, int y, int count, boolean visited[][], int sol[][])
   {
	   if(x == N-1 && y == N-1 && maze[x][y] == 1) //destination achieved
	   {
		   count++;
		   sol[x][y] = 1;
		   printPath(sol);
		   return count;
	   }
	   
	   visited[x][y] = true;
	   sol[x][y] = 1;
	  	   
	   if(isSafe(maze, x, y))
	   {		    
		   //move down
		   if(y+1 < N && !visited[x][y+1])
			   count = pathUtil(maze, x,y+1,count, visited, sol);
		   //move up
		   if(y-1 >=0 && !visited[x][y-1])
			   count = pathUtil(maze, x, y-1, count, visited, sol);
		   //move right
		   if(x+1 < N && !visited[x+1][y])
			   count = pathUtil(maze, x+1, y, count, visited, sol);
		   //move left
		   if(x-1 >=0 && !visited[x-1][y])
			   count = pathUtil(maze, x-1, y, count, visited, sol);		    
	   }
	   
	   visited[x][y] = false;
	   sol[x][y] = 0;
	   return count;
   }
   
   boolean isSafe(int maze[][], int x, int y)
   {
	   return (x<N && x>=0 && y<N && y>=0 && maze[x][y] == 1);
   }
   
   void printPath(int sol[][])
   {
	   for(int i=0;i<N;i++)
	   {
		   for(int j=0;j<N;j++)
		   {
			   out.print(sol[i][j] == 1 ? "* " : 0+" ");
		   }
		   out.println();
	   }
	   out.println();
   }
   
   public static void main(String args[])
   {
	   int maze[][] = {{1,1,0,0},
					   {0,1,0,0},
					   {1,1,1,0},
					   {0,1,1,1}};
					  					  
	  new AllPossiblePaths(4).totalPath(maze,0,0);				   
   }   
}