/*
* Generating all the combinations  1D array
* DFS Approach
*/
import static java.lang.System.*;
import java.util.*;

public class GeneratingAllTheCombinationsInArray
{
    static void solve(int start, int 
	n, int k, List<Integer> list)
	{
		if(k==0)
		{
			out.println(list);
			return;
		}
		
		
	    for(int i= start; i<=n; i++)
		{
			list.add(i); // Add A[i] in case of Array
			solve(i+1, n, k-1, list);	
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String [] args)
	{
		int n = 2;
		int k = 1;
		List<Integer> list = new ArrayList<>();
		solve(1, n, k, list);	
	}
}