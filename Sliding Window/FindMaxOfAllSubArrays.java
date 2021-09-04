/*
* Time complexity : O(n)
* Space complexity: O(k)
*******************
** fixed size window
*/

import static java.lang.System.*;
import java.util.*;

public class FindMaxOfAllSubArrays 
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
			max.removeIf(x->(x<temp));
				
			max.add(temp);
			
			if(j-i+1 == k)
			{
				list.add(max.get(0));
				
				/*
				* Removing Ai from max if present
				*/
				if(!max.isEmpty() && A[i] == max.get(0))
					max.remove(0);
				
				i++;
			}
			
			j++;
		}
		
		return list;
	}
	
	public static void main(String [] args)
	{
		int A[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int n = A.length;
		int k = 3;
		
		out.println(findMax(A, n, k));
	}
}