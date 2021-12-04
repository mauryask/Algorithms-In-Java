// finding all the divisors (factors) of a number
// best approach 
// time complexity T(n) = O(n * sqrt(n)) >> (if there are n numbers)
// better than naive approach (trial division)
// which gives time complexity : O(n^2)

// it gives all the factors (divisors) 
// including prime and non-prime 

import static java.lang.System.*;
import java.util.*;

public class FindingFactors
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(in);
		out.print("Enter a number: ");
		int num = sc.nextInt();
		solve(num);
	}
	
	static void solve(int num)
	{
		for(int i = 1; i<= Math.sqrt(num) ; i++)
		{
			if(num % i == 0)
			{
				if(num/i == i)
					out.print(i+" ");
				else
				{
					out.print(num/i+" ");
					out.print(i+" ");
				}
			}
		}
	}
}