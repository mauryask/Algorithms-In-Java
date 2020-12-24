import static java.lang.System.*;
import java.util.*;

// remove soloution array from every where
// if you don't want to print all the paths
// but want only the total paths

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
		if(row == m-1 && col == n-1 & maze[row][col] == 1)
        {
			count++;
			sol[row][col] = 1;
			printSol();
		}			
		
		sol[row][col] = 1;
		visited[row][col] = true;
		
		if(isSafe(maze, row, col))
		{
			//move down
			if(row+1 < m && !visited[row+1][col])
				allPath(maze, row+1, col);
			//move up
			if(row-1 >=0  && !visited[row-1][col])
				allPath(maze, row-1, col);
			//move right
			if(col+1 < n   && !visited[row][col+1])
				allPath(maze, row, col+1);
			//move left
			if(col-1>=0  && !visited[row][col-1])
				allPath(maze, row, col-1);	
		}
		
		sol[row][col] = 0;
		visited[row][col] = false;
	}
	
	boolean isSafe(int maze[][], int  row, int col)
	{
		return row < m && row>=0 && col < n && col >=0 && maze[row][col]==1; 
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
			            {1,1,1,1},
						{0,1,1,0},
						{1,1,1,1}};
		int row = 0;
		int col = 0
		
		int m = 4; // total row 
		int n = 4; // total col
		
	    new AllPossiblePaths(m,n).allPath(maze,row,col);
		out.println(count);
	}
 }
