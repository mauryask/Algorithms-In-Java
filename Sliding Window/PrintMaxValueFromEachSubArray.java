/*
* Time complexity : O(n*k)
* Space complexity: O(k)
*******************
** fixed size window
*/

import static java.lang.System.*;
import java.util.*;

public class PrintMaxValueFromEachSubArray
{
	static List<Integer> findMax(int A[], int n, int k)
	{
		List<Integer> list = new LinkedList<>();
		List<Integer> max = new LinkedList<>();
		
		int i=0, j=0;
		
		while(j<n)
		{
			/*
			* In order to use local variable 
			* inside the lamda expression 
			* it shouold be final
			*/
			
			/*
			* Before adding the 'temp' to the list
			* remove all the elements from the list
			* that are less than the 'temp'
			*/
			
			final int temp = A[j];
			max.removeIf(x->(x<=temp));
				
			max.add(temp);
			
			if(j-i+1 == k)
			{
				int maxListHead = max.get(0);
				
				list.add(maxListHead);
				
				/*
				* Removing Ai from max if present
				*/
				
				if(max.contains(A[i]))
					max.remove(A[i]);
				
				i++;
			}
			
			j++;
		}
		
		return list;
	}
	
	
	//O(n*logk)
	static void getMax(int[] A, int n, int k)
	{
		Queue<Integer> q = new PriorityQueue<>((a, b)->b-a);
		int i = 0;
		int j = 0;
				
		while(j<n)
		{
			q.add(A[j]); //O(log k)
			
			if(j-i+1 == k)
			{
				int max = q.peek();
				out.print(max+" ");
				
				if(q.contains(A[i])) //log k
				   q.remove(A[i]); //O(log k)
			   
				i++;
			}
			
			j++;
		}
	}
	
		/*
	* Eache opration in dequeu takes O(n)
	* SO T(n) : O(n)
	* S(n) : O(k) 
	*/
	static void usingDeque(int[] A, int n, int k)
	{
		Deque<Integer> q = new LinkedList<>();
		
		int i = 0;
		int j = 0;
		
		while(j < n)
		{
			int item = A[j];
			
			while(!q.isEmpty() && q.getLast() <= item)
				q.removeLast();				
			
			q.add(item);
			
			if(j-i+1 == k)
			{
				int max = q.getFirst();				
				out.print(max+" ");				
				if(max == A[i])
					q.pollFirst();				
				i++;
			}			
			j++;
		}
	}
	
	public static void main(String [] args)
	{
		int A[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int n = A.length;
		int k = 3;
		
		out.println(getMax(A, n, k));
	}
}