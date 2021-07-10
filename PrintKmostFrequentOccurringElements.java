// print 'k' most frequently occuring elements 
// Time Complexity  : O(n)
// Space Complexity : O(n)
 
import static java.lang.System.*;
import java.util.*;

public class PrintKmostFrequentOccurringElements
{	
	public static void main(String [] args)
	{
	   int A[] = {1,1,1,2,2,3,3,3,4,4,5,5,9,8,7,7,4,6,6,6,8,6,3,3,2,5};
       int n = A.length;
	   int k = 2;
	   solve(A, n, k);
	}
	
	static void solve(int A[], int n, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Integer> queue = new PriorityQueue<>((Integer a, Integer b)->
		    {
				return map.get(b) - map.get(a);
			});
			
		for(int i=0;i<n; i++)
			map.put(A[i],map.getOrDefault(A[i],0)+1);
		
		for(Map.Entry<Integer, Integer> m : map.entrySet())
			queue.add(m.getKey());
		
		// don't be confused printing the priority 
		// does not give relative sorting 
		// on removing elemnts one by one you are going to 
		// get the correct output
		
		for(int x : queue)
   			out.println(x+" ==> "+map.get(x));
		out.println("=========");	
		
		for(int i=0; i<k; i++)
		{
			int rs = queue.poll();	
		    out.println(rs+" ==> "+map.get(rs));
		}
	}
 }
