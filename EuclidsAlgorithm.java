//this algorithm is used to find GCD of two numbers
//https://www.techiedelight.com/euclids-algorithm-to-find-gcd-of-two-numbers/

package com.pnstech;

import java.util.Scanner;

public class EuclidsAlgorithm {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		//int n = euclidGCD(a, b);
		 int n = bestEuclid(a, b);
		System.out.print(n);
         sc.close();
	}

	
//this is not much better since it takes more time (consider the following)	
	//replacing the larger of the two by its difference
	static int euclidGCD(int a,int b)
	{
		
		//iterative version
	/*	while(a!=b)
		{
			if(a>b)
				a= a-b;
			else if(b>a)
				b= b-a;
		}*/
		
		//recursive version
		if(a==b)
			return a;
		
			 if(a>b)
				return  euclidGCD(a-b, b);
			 else 
				return euclidGCD(a, b-a);
             	
	}
	
	
//this is the best algorithm not going to take more than 5 steps	
	//replacing the larger of the two by the remainder
	static int bestEuclid(int a, int b)
	{
		//iterative  version
		/*int q, r;
		while(b>0)
		{
			r = a%b;
			a = b;
			b = r;
		}
		
		return a;*/
		//recursive version
		
		if(a%b==0)
			return b;
		else
			return bestEuclid(b, a%b);
		
		
	}

}
