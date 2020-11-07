// this problem demonstrates how to print
// find all the possible paths from a given source to destination
// in a maze
import static java.lang.System.*;

public class AllPossiblePaths
{
	int N;
	int M;
	AllPossiblePaths(int M, int N)
	{
		this.M = M;
		this.N = N;
	}
	
   void totalPath(int maze[][], int row, int col)
   {
	   int count = 0;
	   boolean visited[][] = new boolean[M][N];
	   int sol[][] = new int[M][N];
	   count = pathUtil(maze, row, col, count, visited, sol);
	   out.println(count);
   }

   int pathUtil(int maze[][], int row, int col, 
   int count, boolean visited[][], int sol[][])
   {
	   if(row == M-1 && col == N-1 && maze[row][col] == 1) //destination achieved
	   {
		   count++;
		   sol[row][col] = 1;
		   printPath(sol);
		   return count;
	   }
	   
	   visited[row][col] = true;
	   sol[row][col] = 1;
	  	   
	   if(isSafe(maze, row, col))
	   {		    
		   //move down
		   if(row+1 < M && !visited[row+1][col])
			   count = pathUtil(maze, row+1, col,count, visited, sol);
		   //move up
		   if(row-1 >=0 && !visited[row-1][col])
			   count = pathUtil(maze, row-1, col, count, visited, sol);
		   //move right
		   if(col+1 < N && !visited[row][col+1])
			   count = pathUtil(maze, row, col+1, count, visited, sol);
		   //move left
		   if(col-1 >=0 && !visited[row][col-1])
			   count = pathUtil(maze, row, col-1, count, visited, sol);		    
	   }
	   
	   visited[row][col] = false;
	   sol[row][col] = 0;
	   return count;
   }
   
   boolean isSafe(int maze[][], int row, int col)
   {
	   return (row<N && row>=0 && col<N && col>=0 && maze[row][col] == 1);
   }
   
   void printPath(int sol[][])
   {
	   for(int[] x : sol)
	   {
		   for(int y : x)
		   {
			   out.print(y == 1 ? "* " : 0+" ");
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
	  int row = 0;
	  int col = 0;
	
   	  new AllPossiblePaths(4,4).totalPath(maze,row,col);				   
   }   
}