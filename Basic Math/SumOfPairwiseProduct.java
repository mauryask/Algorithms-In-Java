/*
* T(n) : O(n) 
* S(n) : O(1)
******
https://www.geeksforgeeks.org/sum-pairwise-products/
*/
import static java.lang.System.*;
import java.util.*;

public class SumOfPairwiseProduct
{
	static int getSum(int n)
	{
		int sum = 0;
		
		for(int i=1; i<=n; i++)
			sum += i; 
		
		int result = 0;
		
		for(int i=1; i<=n; i++)
		{
			result += i * sum;
			sum -= i;
		}
		
		return result;
	}
	
	public static void main(String [] args)
	{
		int n = 5;		
		out.println(getSum(n));
	}
}