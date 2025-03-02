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
	static ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
      List<Integer> list = new ArrayList<>();
      ArrayList<Integer> ans = new ArrayList<>();
      int i = 0, j = 0;
      int n = arr.length;
        
      while(j < n)
      {
        int x = arr[j];
		// Do niot use here ele <= x (remove only elements that are less than x)
		// Not that are greater or equal
		// Else the teste case like {8 5 5 5 1 2 3} and k = 3
		// Will not work
        list.removeIf(ele -> ele < x);
        list.add(x);
        
        if(j - i + 1 == k){
            ans.add(list.get(0));
            
            if(arr[i] == list.get(0))
              list.remove(0);
            i++;  
        }
        
        j++;
      }    
        
      return ans;    
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
		int k = 3;		
		out.println(maxOfSubarrays(A, k));
	}
}