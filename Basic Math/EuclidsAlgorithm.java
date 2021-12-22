import java.util.*;

public class EuclidsAlgorithm 
{
	/*
	* Euclids Algorithm
	*****
	* This is the naive approach
	* worst approach
	* Time Complexity : O(min(a, b))
	*****
	** Here th eidea is to find the largest integer
	** that can divide both a and b
	*/
	
	static int naiveApproach(int a, int b)
	{
		// the GCD can not be gretaer than min(a, b)
		int m = (int) Math.min(a,b);
		
		for(int i=m; i>0; i--)
		{
			// finding the first number that can divide both
			if(a % i == 0 && b % i ==0)
			   return i;	
		}
		// 1 is always GCD if no number is found
		return 1;
	}
	
	
	/*
	* This is better than above approach
	* but not the best 
	* as if one number is very much larger than other one
	* time compleixty increases (because alot of subtractions needed)
	********
	* Replace the larger number by the difference between the two
    */
	
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
	
	
    /*
	* This is better than above approach
	* and best if numbers are not coprime
	* not going to take more than 5 times the 
	* number of digits in the smaller number	
	* Time compleixty : O(log(max(a,b)))
	********
	* Replace the larger numbe by the remainder 
    */
	
	static int euclidsAlgo(int a, int b)
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
		
		if(b==0)
			return a;
		else
			return euclidsAlgo(b, a%b);
	}
	
    /**
	* This approach should be used if 
	* two numbers are coprime (GCD = 1)
    */
	
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		//int n = euclidGCD(a, b);
		 int n = naiveApproach(a, b);
		System.out.print(n);
         sc.close();
	}
}
