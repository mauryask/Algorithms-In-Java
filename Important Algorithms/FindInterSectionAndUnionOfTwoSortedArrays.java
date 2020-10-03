import static java.lang.System.*;
public class FindInterSectionAndUnionOfTwoSortedArrays
{
	public static void main(String [] args)
	{
		int A[] = {0,1,4,5,7,9,10};
		int B[] = {4,7,9,10,20};
		
		union(A, B);
		intersection(A,B);
	}
	
	// finding union of two sorted arrays
	
	static void union(int A[], int B[])
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
	
	static void intersection(int A[], int B[])
	{
		
	}
}