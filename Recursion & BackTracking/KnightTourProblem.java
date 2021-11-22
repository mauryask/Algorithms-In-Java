/*
* T(n) : O(2^n)
* S(n) : O(n*n)
*/
import static java.lang.System.*;
import java.util.*;

public class KnightTourProblem 
{
	static void printMoves(int[][] board, boolean visited[][], int x, int y, int move, int n)
	{
	  	if(isSafe(x, y, n, visited))
		{
			board[x][y] = move;
			visited[x][y] = true;
			// allpossible moves of a knigh:(horse)
			/*
			                  # * #
			                #   *   #
			 				* * # * *
			 				#	*   #
							  # * # 
							  							  
				It moves like : 2 vertical + 1 horizontal
			*/
			
			printMoves(board, visited, x+2,y-1,move+1,n);
			printMoves(board, visited, x+2,y+1,move+1,n);
			printMoves(board, visited, x-1,y-2,move+1,n);
			printMoves(board, visited, x+1,y-2,move+1,n);
			printMoves(board, visited, x-2,y-1,move+1,n);
			printMoves(board, visited, x-2,y+1,move+1,n);
			printMoves(board, visited, x+1,y+2,move+1,n);
			printMoves(board, visited, x-1,y+2,move+1,n);
		}
	}
	
	static boolean isSafe(int x, int y, int n, boolean[][] visited)
	{
		return x<n && x>=0 && y<n && y>=0 && !visited[x][y];
	}
	
	public static void main(String [] args)
	{
		int n = 8;
		int board[][] = new int[n][n];
		boolean visited[][] = new boolean[n][n];
		printMoves(board,visited,0,0,0,n);
		
		for(int x[] : board)
		{
			for(int y: x)
				out.print(y+"   ");
			out.println("\n");
		}
	}
}