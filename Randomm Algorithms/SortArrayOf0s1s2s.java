/*
* Time Complexity: O(n) + O(n/2) = O(n)
* Space complexity : O(1)
***************
* idea is to put all 0s at the begining
* Then put all the 1s  after 0s 
* all the 2s automatically will move at the end
**/

/*
* T(n) : O(n)
* Another approach is to count frequency of all 0s, 1s and 2s
* store int three variables
*******************
* T(n) = O(n)
* Now again traverse the array
* replace first 0Count with 0s and after 0s put
* 1Count numnber of 1s then 2Count number of 2s
********************
First solution is better than this
*/

import static java.lang.System.*;

public class SortArrayOf0s1s2s
{
	static void sort(int[]  A, int n)
	{
		int i=0, j=0;
		
		// T(n) = O(n)
		while(j <n)
		{
			if(A[j] == 0)
			{
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
				i++;
			}
			
			j++;
		}
		
		j = i;
		
		// T(n) = O(n/2)
		while(j < n)
		{
			if(A[j] == 1)
			{
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
				i++;
			}
			
			j++;
		}
	}
	
	public static void main(String [] args)
	{
	    int A[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int n = A.length;
		sort(A, n);
		for(int x : A)
			out.print(x+" ");
	 }
}