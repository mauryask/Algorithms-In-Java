import java.util.*;
import static java.lang.System.*;

public class DynamicFibo 
{
	// recursive solution 
	// T(n) : O(2^n)
	// S(n) : O(logn)
	static int recursive(int n)
	{
	  if(n<2)
		return n;
	  else
		return recursive(n-1) + recursive(n-2);
	}
	
	// top-down(memoization) 
	// T(n) : O(n)
	// S(n) : O(n)		  
	 static int memoization(int n, int cache[])
	 {
		if(n<2)
			return cache[n] = n;
		
		if(cache[n]!=0)
			return cache[n];
		
		return cache[n] = memoization(n-1, cache) + memoization(n-2, cache);
	 }

     // Tabular 
	 // T(n) : O(n)
	 // S(n) : O(n)
	  static void tabulation(int n, int cache[])
	  {
		  for(int i=0; i<n+1; i++)
		  {
			  if(i==0 || i==1)
				  cache[i] = i;
			  else
			      cache[i] = cache[i-1] + cache[i-2];
		  }
	  }	
     
	// Best solution
    // T(n) : O(n)
    // S(n) : O(1)
	static void iterative(int n)
	{
		 int first = 0;
		 int second = 1;
		 out.print(first+" "+second+" ");
		 int  sum = 1;
		 for(int i=1; i<n; i++)
		 {
			sum =  first + second;
			System.out.print(sum+" ");
			first = second;
			second = sum;
		 }
	}

    public static void main(String [] args)
	{
		int n = 4;
		int cache[] =  new int[n+1];
		iterative(n);
		//out.println(iterative(n));
	}	
}
