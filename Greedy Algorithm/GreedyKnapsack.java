/*
* Greedy (Fractional) Knapsack problem
* It is standard Greedy Algorithm problem
***********
* Time complexity  : O(n*logn)
* Space complexity : O(n)
*/

import static java.lang.System.*;
import java.util.*;

class ItemValue
{
	int profit;
	int weight;
	double pwRatio;
	
	ItemValue(int profit, int weight)
	{
       this.profit = profit;
	   this.weight = weight;
	   pwRatio = (double) profit / (double) weight;
	}
}

public class GreedyKnapsack
{
	static int maxProfit(int[] profit,int[] weight, 
	int n, int capacity)
	{
		// if no items are knapsack size is zero 
		// profit will be zero
		
		if(capacity == 0 || n == 0)
			return 0;
		
		ItemValue[]  items = new ItemValue[n];
		
		for(int i=0; i < n; i++)
		  items[i] = new ItemValue(profit[i], weight[i]);
	   
	   /*
	   * Sorting the objects based on
	   * profit/weight ratio in descending order
	   */
	   
	    Arrays.sort(items, (a, b)->(int)(b.pwRatio-a.pwRatio));
		
		int totalProfit = 0;
		
		for(int i= 0; i<n; i++)
		{
			/*
			* Check if the bag is still empty
			* and I-th object can be accomodated in it 
			* completely
			*/
		
			if(items[i].weight <= capacity)
			{
				capacity -= items[i].weight;
				totalProfit += items[i].profit;
			}
			else //Take a fraction of the object if can not be kept completely
			{
				totalProfit += items[i].pwRatio * capacity;
				break; //Since remaining space in Knapsack is 0: break
			}
		}
				
		return totalProfit;
	}
	
	
	public static void main(String [] args)
	{
	    int[] profit = {60, 40, 100, 120};
		int[] weight = {10, 40, 20, 30};
		int capacity = 50;
		
		int n = profit.length;
		
		out.println(maxProfit(profit, weight, n, capacity));
	}
}