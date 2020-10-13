// pure dynamic programing approach to find fibonocci series up to N 
// time complexty O(n)
// space complexity O(n)
// but this is still not that much efficien
import java.util.*;
public class DynamicFibo 
{
      public static void main(String [] args)
		{
			int N = 4;
			
			/*===> bottom up dynamic programing <===*/		
            //int cache[] = new int[N+1];
			//fib(N,cache);
			
			
			/*====> the efficient solution <===*/
			//fib2(N);
			
			/*===> the top-down approach <===*/
			//cache[0] = 0;
			//cache[1] = 1;
			//and initialize remaining elements to Zero
			//fib1(N,cache);
			
			
			//for(int x : cache)
				//System.out.print(x+" ");
			
			for(int i=0; i<N; i++)
				System.out.print(fib3(i)+" ");
		}


/*
................. 1 ..................
*/

//pure dynamic programing spolution
//bottom-up approach
//time complexity O(n)
//space complexity O(n)
//but this is not efficient that much
//tabular approach 
      static void fib(int N, int cache[])
	  {
		  for(int i=0; i<=N; i++)
		  {
			  if(i==0 || i==1)
				  cache[i] = i;
			  else
			      cache[i] = cache[i-1] + cache[i-2];
		  }
	  }	

/*
................. 2 ..................
*/

//top down approach
//dynamic programing
//time complexity O(n)
//space complexity O(n)
//recursive approach

static int fib1(int N, int cache[])
{
	if(N<2)
		return N;
	if(cache[N]!=0)
		return cache[N];
	return cache[N] = fib1(N-1, cache) + fib1(N-2, cache);
}


/*
................. 3 ..................
*/

//the efficient solution 
//here time complexity O(n)
//but the space complexity O(1)
//so it should be used in future
// best appraoch
static void fib2(int N)
{
 int first = 0;
 int second = 1;
 int  sum = 0;
 for(int i=0; i<N; i++)
 {
	System.out.print(sum+" ");
	sum =  first + second;
	first = second;
	second = sum;
 }
}

/*
................. 4 ..................
*/

//the basic approach 
//using recursion without dynamic programing
//time complexity O(2^n)
//space complexity O(n)

static int fib3(int n)
{
  if(n<2)
	return n;
  else
	return fib3(n-1) + fib3(n-2);
}
 
}
