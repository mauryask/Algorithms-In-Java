// Given array with of n natuarl numbers
// No number is being reapting 
// A number is missing find the  missing number

// Time Complexity : O(n)
// Space Complxity : O(1)

import static java.lang.System.*;

public class FindMissingNumber
{
	public static void main(String [] args)
	{
	    int A[] = {1,2,10,9,5,7,4,6,8};
		int n = 10; // number of natural number
		method1(A, n);
		method2(A, n);
	}
	
	//sum approach
	static void method1(int A[], int n)
	{
	   // sum of n natural numbers
	   int sum = n*(n+1)/2;
	   
	   // now find the sum of the array elements
	   int arr_sum = 0;
	   for(int x: A)
		   arr_sum += x;
	   // the missing number is 
	   out.println(sum - arr_sum);
	}
	
	//xor approach
	static void method2(int A[], int n)
	{
		// find xor of numbers from 1 to n
		int xor_n = 0;
		for(int i=1; i<=n; i++)
			xor_n ^= i;
		
        // find xor of the array elements
	    int arr_xor = 0;
		for(int x : A)
			arr_xor ^= x;
		
		//the missing number
		out.println(xor_n ^ arr_xor);
	}
}