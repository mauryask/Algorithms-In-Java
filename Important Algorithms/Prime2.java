// Algorithm to check if a number is prime or not
// time complexity : O(√n)
// idea os to find all the possible divisor of the number
// if it is greatervthan two then composite else prime (1 and itself)

import static java.lang.System.*;
class Test
{
    public static void main(String args[] ) 
	{
       int n = 120589777;
	   int count  = 0;
		for(int i=1;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				if(n/i==i)
					count++;
				else
					count+=2;
			}
		}
		
		if(count > 2)
			out.println("Composite");
		else // divisible by only one and itself
			out.println("Prime");
    }
}
