// Sieve Of Eratosthenese Algorithm
// this Algorithm is basically 
// demonstrates how to print all the 
// prime numbers within a given range
// form 2 to n 
// Time complexity is T(n) = O(n log log n)) >> (if n numbers are given)
// it is better than trial division method
// which takes O(n^2) time >> in case of n numbers

// it also can be used to find
// prime factors (divisors) of the given number

import static java.lang.System.*;
import java.util.*;

public class SieveOfErastothenes
{
	// size of the sieve array
	static int n = 1000000; 
	static boolean prime[] = new boolean [n];
	
	public static void main(String [] args)
	{
	   	Scanner sc = new Scanner(in);
		out.print("Enter a number: ");
		int num = sc.nextInt();
		solve(num);
		sc.close();
	}
	
    static void solve(int num)
	{
		// initiallay every entry is marked as false
		// which indicates every number is prime
		
		for(int i = 2; i<Math.sqrt(num) ; i++)
		{
			if(!prime[i]) // if false (means prime)
			{
			  // mark all the factors of i >> from its square to num --true
			  // since they are composite
			  
			  for(int j = i*i; j<num; j += i)
				prime[j] = true;	
			}
		}
		
		// printing all the prime numbers 
		// within the given range
		
		for(int i=2;i<num;i++)
		{
			out.print(prime[i] == false ? i+" " :"");
		}
	}
}
