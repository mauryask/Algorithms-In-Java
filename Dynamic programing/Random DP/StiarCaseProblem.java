/*
* It is nothing but DP implementation of 
* fibonocci series if (m = 2)
* if m = 3....; fib(n-1) + fib(n-2) + fib(n-3)..
----------------------------
** Just return N-th element
** of the fibonocci series
*/

import static java.lang.System.*;
import java.util.*;

public class StiarCaseProblem
{	
    // Top down (memoization)
	/*
	* T(n) : O(n)
	* S(n): O(n)
	*/
	
	static int stairCase(int n, int dp[])
	{
		if(n==0 || n==1)
			return dp[n] = 1;
		
		if(dp[n] != -1)
			return dp[n];
		
		return dp[n] = stairCase(n-2, dp) + stairCase(n-1, dp);
	}
	
	// Recursive 
	/*
	* T(n) : O(2^n)
	* S(n) : O(n)
	*/
	static int recursive(int n)
	{
		if(n==1 || n==0)
			return 1;
		return recursive(n-1) + recursive(n-2);
	}
	
	// simple iterative solution 
	static int totalWays(int n)
	{
		// base case
		if(n==0 || n==1)
			return 1;
		
		int a = 1;
		int b = 1;
		int sum  = 0;
		
		for(int i=1; i<n; i++)
		{
			sum = a+b;
			a = b;
			b = sum;
		}
		
		return sum;
	}
	
	public static void main(String [] args)
	{
		int n = 4; //stairs 
		int m = 2; // max jump length
		
		int dp[] = new int[n+1];
		
		Arrays.fill(dp, -1);
		
        /*out.print(stairCase(n,dp));*/		
		out.print(recursive(n));
		//out.println(totalWays(n));
	}
}