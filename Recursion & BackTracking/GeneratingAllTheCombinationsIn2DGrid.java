/*
* Geneerating all the combinations of 3 elements 
* in a 2D grid DFS approach (Very costly)
*/
import static java.lang.System.*;
import java.util.*;

public class GeneratingAllTheCombinationsIn2DGrid 
{
	static class Test 
	{
		int x;
		int y;
		
		Test(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	static void generate(int[][] grid, int start, List<Test> list,
	int n, int k)
	{
		if(k==0)
		{
			for(int x[] : grid)
			{
				for(int y : x)
					out.print(y+" ");
				out.println();
			}
			
			out.println("\n");
			return;
		}
		
		for(int i=start; i<n; i++)
		{
			Test t = list.get(i);
			int temp = grid[t.x][t.y];
			grid[t.x][t.y] = 2;
			generate(grid, i+1, list, n, k-1);
			grid[t.x][t.y] = temp;
		}
	}
	
	public static void main(String [] args)
	{
		int grid[][] = {{1,1,1},{1,1,1},{1,1,1,}};
		int m = grid.length;
		int n = grid[0].length;
		int k = 3;
		
		List<Test> list = new ArrayList<>();
		
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			  list.add(new Test(i, j));
		}
		
		generate(grid, 0, list, m*n, k);
	}
}