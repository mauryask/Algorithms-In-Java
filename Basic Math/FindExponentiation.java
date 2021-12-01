/*
* T(n) : O(log n): since every time the problem 
* reduces to half 
* S(n) : O(1)
***********
* idea is to break x^n = (x^2)^n/2 (if n is even)
* x^n = (x*x^n-1) (if n is odd) 
*/

import static java.lang.System.*;
import java.util.*;

public class FindExponentiation 
{
	static int findExpo(int x,int n)
	{
		int result =  1;
		
		while(true)
		{
			if(n%2 == 1)
				result *= x;
			// this line prevents one extra multiplication
			if(n==0)
				break;
			
			x =  x*x;
			/*
			* Note: n/2 adn (n-1)/2 will give same result
			* if n is odd, so need to make n = (n-1)/2 in case of odd
			*/
			n = n/2;
		}
		
		return result;
	}
	
	static int myOwnUnderStanding(int x, int n)
	{
		int result = 1;
		
		while(true)
		{
			if(n%2 == 1)
				result *= x;
			
			// if n is odd then n/2 and (n-1)/2 
			// are going to give the same result
			n = n/2;
			
			// prevents an extra multiplication
			if(n==0)
				break;
			
			x = x*x;
		}
		
		return result;
	}
	
	
	static int findExpoRecursive(int x, int n)
	{
		if(n==0)
			return 1;
		
		if(n%2==0)
			return findExpoRecursive(x*x, n/2);
		else
		/*
		* Note: n/2 adn (n-1)/2 will give same result
		* if n is odd
		*/
			return x * findExpoRecursive(x*x, (n-1)/2);
	}
	
	public static void main(String args[])
	{
		int x = 2;
		int n = 6;
		
		//out.println(findExpo(x, n));
		out.println(myOwnUnderStanding(x, n));
	}
}