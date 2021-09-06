/*
* Finding kth Smallest element 
* in an unsorted array
****************
Avearge and Best Case: 
* T(n) : O(n)
Worst Case: (when array is sorted)
* T(n) : O(n*n)
******************
Idea is to apply quick sort 
*****
After each call to the partition method
one element reaches to its proper position
*****
As the result index "pivot" will contain
* "pivot+1"  element (since index starts from 0)
****
So compare (pivot+1) with k
** if  (pivot+1) = k this is the kth element
** if  (pivot+1) < k element will be in right subarray
** if (pivot+1) > k element will be in left subarray
*** as all the elements to left of pivot are less or equal 
*** and to right are greater 
*/

/*
* To find Kth largest element
* apply reverse sorting (Descending order)
*/

import static java.lang.System.*;

public class QuickSelectAlgorithm
{	
	static int partition(int A[], int start,int end)
	{
		int temp = A[end];
		int i = start - 1;
		
		for(int j = start; j < end; j++)
		{
			if(A[j] <= temp)
			{
				i++;
				int x = A[j];
				A[j] = A[i];
				A[i] = x;
			} 
		}
		
		A[end] = A[i+1];
		A[i+1] = temp;
		
		return i+1;
	}
	
	static int findKthSmallest(int[] A,int start, int end, int k)
	{
			int pivot = partition(A, start, end);
			
			if(pivot+1 == k)
				return A[pivot];
			else if(pivot+1 < k)
				return findKthSmallest(A, pivot+1, end, k);
			else 
				return findKthSmallest(A, start, pivot-1, k);
	}
	
	public static void main(String [] args)
	{
		int A[]  = {10, 4, 5, 8, 6, 11, 26};
		int  n =  A.length;
		int k =  3;
		out.println(findKthSmallest(A, 0, n-1, k));
	}
}