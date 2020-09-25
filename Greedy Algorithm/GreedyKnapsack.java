//greedy knapsack algorithm (or fractional knapsack algorithm)
//time complexity depends on sorting algorithm being used
//here in case of insertion sort time complexity is : O(n^2)
//in case of merge sort time complexity is : O(n * log n)

import java.util.*;

public class GreedyKnapsack
{
	public static void main(String [] args)
	{
		int p[] = {25, 24, 15}; //profit array
		int w[] = {18, 15, 10}; //weight array
		int m = 20; //size of the knapsack
		
		greedyKnapsack(p ,w, m);
	}
	
	static class Heap implements Comparable<Heap>
	{
		int p;
		int w;
		float pw;
		
		@Override
		public int compareTo(Heap o)
		{
			float diff = o.pw - this.pw;
			if(diff < 0)
				return -1;
			else
				return 1;
		}
	}
	
	static void greedyKnapsack(int p[], int w[], int m)
	{
		Heap heap[] = new Heap[p.length];
			
	    for(int i=0; i<p.length; i++)
	    {
	    	heap[i] = new Heap();
			heap[i].p = p[i];
			heap[i].w = w[i];
			heap[i].pw = (float)p[i]/(float)w[i];
	    }
	    
		Arrays.sort(heap);
		
		
		for(Heap x : heap)
			System.out.println(x.p+", "+x.w+", "+x.pw);
		
	    float profit = 0.0f; //total profit
	    int i; 
	    
		for(i=0; i<p.length; i++)
	    {
	    	if(m > 0 && heap[i].w <= m)
	    	{
	    		m = m - heap[i].w;
	    		profit += heap[i].p;
	    	}
	    	else
	    		break;
	    }
	    
	    if(m > 0)
	    {
	    	profit = profit + heap[i].pw * m;
	    }
	    
	    System.out.println(profit);
	}
}