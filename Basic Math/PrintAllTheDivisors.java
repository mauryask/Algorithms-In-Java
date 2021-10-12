/*
* Note: factors and divisors are same
*/
import static java.lang.System.*;
import java.util.*;

public class PrintAllTheDivisors 
{
	// T(n) : O(sqrt(n))
	// S(n) : O(sqrt(n))
	// The idea: divisors are always found in pair
	
	static void printDivisor(int n)
	{
	   int x = (int)Math.sqrt(n);
	   List<Integer> list = new ArrayList<>();
	   
        for(int i=1; i<=x; i++)
	    {
		    if(n%i==0)
		    {
				   list.add(i);
				   
				   if(n/i != i)
				     list.add(n/i);
		    }
	    }
		
		for(int y : list)
			out.print(y+" ");
	 }		   

  // T(n) : O(n)
  // S(n) : O(1)
  
  static void naiveMethod(int n)
  {
	  for(int i=1; i<=n; i++)
		  if(n%i==0)
			  out.print(i+" ");
  }

	public static void main(String [] args)
	{
		int n = 4;
	    //printDivisor(n);		
	    naiveMethod(n);		
	}
}