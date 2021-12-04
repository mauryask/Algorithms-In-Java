// finding all the prime factors in an efficeient way

import static java.lang.System.*;

public class FindAllThePrimeFactors
{
	public static void main(String [] args)
	{
	  int n = 315;
	  method2(n);	
	}
	
	// this is the best and ptimized solution
	// to fins all the prime factors of a number
    static void method2(int n)
	{
		// find all the 2's
		
		while(n % 2 == 0)
		{
			out.print(2+" ");
			n  = n/2;
		}
		
		// since roots are found in pairs (thats why used square root)
		// and even numbers can not be prime (thats why i+=2)
		
		for(int i=3; i<=Math.sqrt(n); i+=2)
		{
			// this is used to find all the number of i's 
			// that are present as the prime factor of n
			// similiar to finding all the 2's above
			
			while(n%i==0)
			{
				out.print(i+" ");
				n = n/i;
			}
		}
		
		// this is to handle the case when n is
		// prime and greater than 2
		
		if(n > 2)
			out.print(n);
	}
	
	// not an efficeint solution
	
	static void method1(int n)
	{
		for(int i=2;i<n; i++)
		{
			while(n % i == 0)
			{
			   out.print(i+" ");
			   n = n/i;
			}
		}
		
		if(n > 2)
			out.println(n);
	}
}