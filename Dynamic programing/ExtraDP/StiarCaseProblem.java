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
	public static void main(String [] args)
	{
		int n = 5; //stairs 
		int m = 2; // max jump length
		
		int dp[] = new int[n+1];
        /*out.print(stairCase(n,dp));*/		
		out.print(recursive(n));
	}
		
    // Top down (memoization)
	/*
	* T(n) : O(n)
	* S(n): O(n) > recursion stack
	*/
	static int stairCase(int n, int dp[])
	{
		if(n==0 || n==1)
			return dp[n] = 1;
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
}