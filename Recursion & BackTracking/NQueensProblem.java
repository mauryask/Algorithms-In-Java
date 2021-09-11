import static java.lang.System.*;
public class NQueensProblem
{
	public static void main(String [] args)
	{
		int n = 4;
		int board[][] = new int[n][n];
		out.println("\n "+placeTheQueen(board,0,n));
	}
	
	static boolean placeTheQueen(int board[][], int col,int n)
	{
		if(col==n)
		{
			printSol(board,n);
			return true;
		}
		
		/// if you want to print all the possible solutions
		//  boolean res = false; 
		 
		for(int i=0;i<n; i++)
		{
		   if(isSafe(board, i, col, n))
		   {
			   board[i][col] = 1;
			   //res = placeTheQueen(board,col+1, n);
			   if(placeTheQueen(board, col+1, n))
				   return true;
			   board[i][col] = 0;
		   }			   
		}
		
		//return res;
		return false;
	}
	
	static boolean isSafe(int board[][],int row,int col, int n)
	{
		// checking row on the left side
		for(int i=0;i<col; i++)
		  if(board[row][i] == 1)
			  return false;
		  
		// checking upper diagonal on the left side
		for(int i=row, j=col ;i>=0 && j>=0 ;i--,j--)
		  if(board[i][j] == 1)
			  return false;
		  
		// checking lower diagonal on the right side  
		for(int i=row,j=col; i<n && j>=0;i++, j--)
		  if(board[i][j] == 1)
			  return false;
		  
	    return true;
	}
	
	static void printSol(int board[][], int n)
	{
    	out.println("\n***************");
		for(int[] x : board)
		{
			for(int y : x)
			{
				out.print(" "+y+" ");
			}
			
			out.println();
		}
	}
}