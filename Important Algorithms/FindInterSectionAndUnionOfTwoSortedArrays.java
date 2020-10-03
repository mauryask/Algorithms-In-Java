// finding union and intersectionof two sorted arrays
// if not sorted ten sort the arrays (sorting time complexity will be added to it)
 
/**
* Similiar queation find the common nodes in a binary search tree
* find inorder traversal store elemnts in two arrays 
* it will give arrays in sorted arrays
* find interscetion of both of the arrays like below demonstrated
* Time Complecity : O(m+n)
*/ 

/**
* I have one more O(m+n) solution but space complexity will be increaesd
* use hash table push all the elemnts of one of the array into it
* traverse the firts array and for each element check if it is already 
* present in the has table : print it 
* Time Complecity : O(m+n)
*/
 
import static java.lang.System.*;

public class FindInterSectionAndUnionOfTwoSortedArrays
{
	public static void main(String [] args)
	{
		int A[] = {0,1,4,5,7,9,10};
		int B[] = {4,7,9,10,20};
		
		//union(A, B);
		intersection(A,B);
	}
	
	// finding union of two sorted arrays
	
	static void union(int A[], int B[]) // Time Complexity : O(m+n)
	{
		int i=0, j=0;
		int m = A.length;
		int n = B.length;
		
		while(i < m && j <n)
		{
			if(A[i] < A[j])
				out.print(A[i++]+" ");
			else if(A[i] > A[j])
				out.print(A[j++]+" ");
			else if(A[i] == A[j])
			{
			   out.print(A[i++]+" ");	
			   j++;
			}
		}
		
		//print remaining element 
		while(i<m)
			out.print(A[i++]+" ");
		while(j<n)
			out.print(A[j++]+" ");
	}
	
	static void intersection(int A[], int B[]) // Time Complexity : O(m+n)
	{
		int m = A.length;
		int n = B.length;
		int i=0, j=0; 
		while(i<m && j<n)
		{
			if(A[i] == B[j])
			{
			   out.print(A[i++]+" ");
			   j++;
			}
			else if(A[i] < B[j])
				i++;
			else 
				j++;
		}
	}
}