/*
* Finding larrgest size square sub matrix 
* with all 1s
** https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
** 
https://www.youtube.com/watch?v=UagRoA3C5VQ
*/
import static java.lang.System.*;
import java.util.*;

public class LargestSquareSubmatrixWithAll1s
{
  // if it is not allowed to modify the given matrix
  // T(n) : o(m*n)
  // S(n) : O(m*n)
  
  static int largestMatrix2(int grid[][], int m,int n)
  {
     int maxSize = Integer.MIN_VALUE;
     int dp[][] = new int[m][n];

     for(int i=m-1; i>=0; i--)
	 {
		 for(int j=n-1; j>=0; j--)
		 {
			 if(i==m-1 || j==n-1)
			   dp[i][j] = grid[i][j]; 
		   
			 else if(grid[i][j] == 1)
			 {
				dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]))+1;
				
				maxSize = Math.max(maxSize, dp[i][j]);
			 }
		 }
	 }		 
	 
	 return maxSize;
  }

 // T(n) : O(m*n)
 // S(n) : O(1)
  static int largestMatrix(int[][] grid, int m,int n)
  {
	  int maxSize = Integer.MIN_VALUE;
	  
	  for(int i=m-2; i>=0; i--)
	  {
		  for(int j=n-2; j>=0; j--)
		  {
			  if(grid[i][j] == 1)
			  {
				  grid[i][j] = Math.min(grid[i+1][j+1], Math.min(grid[i][j+1], grid[i+1][j]))+1;
				  
				  maxSize = Math.max(maxSize,grid[i][j]);
			  }
		  }
	  }
	  
	  return maxSize;
  }
	
	public static void main(String [] args)
	{
		int grid[][] = {{0,1,1,1,1},
						{0,0,1,1,1},
						{1,1,1,1,1},
						{0,1,1,1,1},
						{0,1,1,1,1}};
						
	  int m = grid.length;
      int n = grid[0].length;
	  
	  //out.println(largestMatrix(grid, m, n));
	  //out.println(largestMatrix2(grid, m, n));
	  out.println(bruteForce(grid, m, n, m-1, n-1));
	}
}