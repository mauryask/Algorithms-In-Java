/*
* T(n) : O(8^n)
* S(n) : O(n*n)
*/

import static java.lang.System.*;
import java.util.*;

public class SudokuSolver 
{
	static void solveSudoku(int[][] board, int i, int j,int n)
	{
		// Done with all the rows 
		if(i== n)
		{
			printBoard(board);
		    return;	
		}
		
		int ni = 0;
		int nj = 0;
		
		if(j==n-1)
		{
		  ni = i+1;
          nj = 0;		  
		}
		else
		{
			ni = i;
			nj = j+1;
		}
		
		if(board[i][j] != 0)
			solveSudoku(board, ni, nj, n);
		else
		{
			for(int p=1; p<=9; p++)
			{
				if(isSafe(board, i, j, p, n))
				{
					board[i][j]  = p;
					solveSudoku(board, ni, nj, n);
					board[i][j] = 0;
				}
			}
		}
	}
	
	static boolean isSafe(int A[][], int i, int j,int k, int n)
	{
		// check in the row
		for(int p=0; p<n; p++)
			if(A[p][j] == k)
			  return false;
		  
		// check in the column
		for(int p=0; p<n; p++)
			if(A[i][p] == k)
			  return false;
		
		// finding index of the top-left element of the submatrix 
		// in which the current element is present
		int subi = 3*(i/3);
		int subj = 3*(j/3);
		
		// check in the sub matrix
		for(int p=0; p<3; p++)
		{
			for(int q=0; q<3; q++)
			{
				if(A[subi+p][subj+q] == k)
				 return false;
			}
		}
		
		return true;
	}
	
	
	static void printBoard(int[][] board)
	{
		for(int x[] : board)
		{
			for(int y: x)
				out.print(y+" ");
			out.println();
		}
	}
	
	public static void main(String [] args)
	{
		int n = 9;
		int board[][] =  
		 {{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
         {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		 
		solveSudoku(board,0,0,9);
	}
}