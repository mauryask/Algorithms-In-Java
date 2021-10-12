/*
* T(n) : O(n) 
* S(n) : O(1)
******
https://www.geeksforgeeks.org/sum-pairwise-products/
*/
import static java.lang.System.*;
import java.util.*;

public class SumOfPairwiseProduct
{
	static int getSum(int[] A, int n)
	{
		int sum = 0;
		int temp = 0;
		
		for(int x : A)
			sum += x; 
		
		temp = sum;
		
		int mult = 1;
		
		for(int i=1; i<n; i++)
		{
			temp = ((temp/mult)-A[i-1])*(i+1);
			sum += temp;
			mult = i+1;
		}
		
		return sum;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,2,3,4,5};
		// or n = 5 (it will work like same)
		
		out.println(getSum(A, A.length));
	}
}