// finding x^ n in a very efficient manner
// timr complexity : O(log n)
// much better than naive approach
// whose time complexity is : O(N)

import static java.lang.System.*;
public class MultiplyingUpToXpN
{
	public static void main(String [] args)
	{
		int rslt = 1;
		int x = 3;
		int n = 7;
		while(true)
		{
			if(n % 2 == 1)
				rslt *= x;
			n =  n/2;
			if(n == 0)
				break;
			x = x*x;
		}
		out.println(rslt);
	}
}
