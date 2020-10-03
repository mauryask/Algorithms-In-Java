// finding size of largest square block in a 2D grid
// maxium size sub matrix with all 1s

import static java.lang.System.*;

public class LargestSizeSubMatrixWithAll1s
{
	public static void main(String [] args)
	{
		int grid[][] = {{0,1,1,1,1},
						{0,0,1,1,1},
						{1,1,1,1,1},
						{0,1,1,1,1},
						{0,1,1,1,1}};
						
		int a = solve(grid, 5);				
		out.println(a+"*"+a);			
	}
	
	static int solve(int grid[][], int n)
	{
		int sol[][] =  new int[n][n];
		sol[0][0] = grid[0][0];
		int max = Integer.MIN_VALUE;
		for(int i=1;i<n; i++)
		{
			for(int j=1; j<n; j++)
			{
				if(grid[i][j] == 1)
				{
                    sol[i][j] = Math.min(sol[i-1][j], Math.min(sol[i][j-1], sol[i-1][j-1]))+1;					
				    if(max < sol[i][j])
						max = sol[i][j];
				}
				else
					sol[i][j] = 0;
			}
		}
		
		return max;
	}
}