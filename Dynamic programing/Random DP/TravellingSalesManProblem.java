import static java.lang.System.*;
import java.util.*;

public class TravellingSalesManProblem 
{
	static int minCost = Integer.MAX_VALUE;
	static int cost = 0; 
	
	static void minCostPath(int[][] A, int n, boolean visited[][], int src)
	{
		for(int i=0; i<n; i++)
		{
			if(A[src][i] != 0 && !visited[src][i])
			{
				cost += A[src][i];
				visited[src][i] = true;
				minCostPath(A, n, visited, i);
				minCost = Math.min(minCost, cost+A[src][0]);
				out.println(minCost);
				cost -= A[src][i];
				visited[src][i] = false;
			}
		}
	}
		
	public static void main(String [] args)
	{
		int A[][] = {{0,16,11,6},
			         {8,0,13,6},
				     {4,7,0,9},
					 {5,12,2,0}};
		int n = A.length;
		boolean[][] visited = new boolean[n][n];
		
		minCostPath(A, n, visited,0);
		out.println(minCost);
	}
}