// Best to find x^n 
// Time Complexity : O(log n)
// if modular exponent is asked 
// use % mod with each temporary operation

import static java.lang.System.*;

public class FindingModularExponent
{
	public static void main(String [] args)
	{
		int x = 2;
		int n = 8;
        int result = 1;
		
		
		/** 
		* O(n) solution
		* inefficient requires a lot of multiplication
		
	    	for(int i=1;i<=n; i++)
		      rslt *= x;
		
		*/		
		
		// best solution (follow this)
		
		while(n>0)
		{
			if(n % 2 != 0)
				result = (x*result) // % mod;
			x = (x*x) // % mod;
			n = n/2;
		}
		
		out.println(result);
	}
}