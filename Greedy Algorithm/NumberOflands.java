import static java.lang.System.*;
import java.util.*;

public class NumberOflands 
{
	static int countIslands(int sea[][], int n)
	{
		boolean visited[] = new boolean[n];
		int totalIslands = 0;
		
		for(int i=0; i<n; i++)
		{
			if(!visited[i])
			{
				totalIslands++;
				bfsUtil(sea, n, i, visited);
			}
		}
		
		return totalIslands;	
	}
	
	
	static void bfsUtil(int sea[][], int n , int src, boolean [] visited)
	{
		visited[src] = true;
		Queue<Integer> q = new LinkedList<>();
		
		q.add(src);
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			
			for(int i=0; i<n; i++)
			{
				if(sea[u][i] == 1 && !visited[i])
				{
					visited[i] =  true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String [] args)
	{
		int sea[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}};
		int  n = sea.length;
        out.println(countIslands(sea, n)); 
	}
}