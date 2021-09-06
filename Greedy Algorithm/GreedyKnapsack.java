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

public class GreedyKnapSack
{
	static int maxProfit(int[] profit,int[] weight, 
	int n, int capacity)
	{
		ItemValue[]  items = new ItemValue[n];
		
		for(int i=0; i < n; i++)
		  items[i] = new ItemValue(profit[i], weight[i]);
	   
	   /*
	   * Sorting the objects based on
	   * profit/weight ratio in descending order
	   */
	   
	    Arrays.sort(items, (a, b)->
		{
			return (int)(b.pwRatio-a.pwRatio);
		});
		
		int totalProfit = 0;
		int i = 0;
		
		for(; i<n; i++)
		{
			/*
			* Check if the bag is still empty
			* and I-th object can be accomodated in it 
			* completely
			*/
			if(capacity > 0 && items[i].weight <= capacity)
			{
				capacity -= items[i].weight;
				totalProfit += items[i].profit;
			}
			/*
			* If i-th object can not be accomodated
			* completely break the loop
			*/
			else
				break;
		}
		
		/*
		* Check if bag is empty
		* if yes means only a fraction of i-th object
		* can be accomodated into it
		************
		* Since we already have calculated
		* the p/w ratio (profit of 1-unit of object)
		* so profit by puting the fraction in the bag
		* capacity * pwRatio (for i-th object)
		*/
		
		if(capacity > 0)
			totalProfit +=  items[i].pwRatio * capacity;			
		
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