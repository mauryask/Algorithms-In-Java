/*
* Given N*N board and N-queens 
* Place the queen in such a way so that no 
* two queens are under attack 
***
Queen can move 
*********************
1) horizontally
2) vertically 
3) diagonally (both diagonal)
***********
Two queens will be under attack if: 
-> they are in same row 
-> same coloumn 
-> same diagonal
** T(n) : O((8))
*/

import static java.lang.System.*;
import java.util.*;

public class NQueensProblem
{
    static int count  = 0;
		
	// printing all the possible 
	// solution 
	
	static void placeTheQueen(int board[][], int col,int n)
	{
		if(col==n)
		{
			printSol(board,n);
			count++;
			out.println();
		}
		
		for(int i=0;i<n; i++)
		{
		   if(isSafe(board, i, col, n))
		   {
			   board[i][col] = 1;
			   placeTheQueen(board,col+1, n);
			   board[i][col] = 0;
		   }			   
		}
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
		for(int[] x : board)
		{
			for(int y : x)
			{
				out.print(" "+y+" ");
			}
			
			out.println();
		}
	}
	
	public static void main(String [] args)
	{
		int n = 4;
		int board[][] = new int[n][n];
		placeTheQueen(board,0,n);
		out.println("Total solution: "+count);
	}
}


/*

*** printing only one solution
*** returning true and false only

	static boolean placeTheQueen(int board[][], int col,int n)
	{
		if(col==n)
		{
			printSol(board,n);
			return true;
		}
		
		for(int i=0;i<n; i++)
		{
		   if(isSafe(board, i, col, n))
		   {
			   board[i][col] = 1;
			   if(placeTheQueen(board,col+1, n))
				   return true;
			   board[i][col] = 0;
		   }			   
		}
		
		return false;
	}
*/