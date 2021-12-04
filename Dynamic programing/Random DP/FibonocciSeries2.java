import static java.lang.System.*;
import java.util.*;

public class FibonocciSeries2 
{
	// Top down (memoization)
	/*
	* T(n) : O(n)
	* S(n) : O(n) > recursion stack
	*/
	/*
	* If we want 0 to to be included
	* dp[n+2]
	* n == 0 > dp[n] = 0
	* n==1 || n==2 > dp[n] = 1
	*/
	static int fib(int n,int[] dp)
	{
		if(n==0 || n==1)
			return dp[n] = 1;
		
		if(dp[n] != -1)
			return dp[n];
		
		return dp[n] = fib(n-1, dp) + fib(n-2, dp);
	}
	
	//iterative (Completely difrent from DP implementation)
	
	/*
	* T(n) : O(n)
	* S(n) : O(1)
	*/
	
	static void iterative(int n)
	{
		int a = 1;
		int b = 1;
		out.print(a+" "+b+" ");
		
		int count  = 4;
		
		while(count-->0)
		{
			int sum = a+b;
			out.print(sum+" ");
			a = b;
			b = sum;
		}
	}
	
	public static void main(String [] args)
	{
		int n = 5;
		/*int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		fib(n, dp);
		for(int x: dp)
			out.print(x+" ");*/
		iterative(n);
	}
}