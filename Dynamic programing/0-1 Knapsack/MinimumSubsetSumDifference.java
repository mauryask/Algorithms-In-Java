// minimum subset sum diffrence
// very important and
// beautiful problem of dynamic programming

import static java.lang.System.*;
import java.util.*;

public class MinimumSubsetSumDifference
{
	public static void main(String [] args)
	{
	int set[] = {3, 1, 4, 2, 2, 1};//{1,2,7};
		int n = set.length;
		
		int sum = 0;
		//take sum as the sum of all the elemnts of the set
		for(int i=0; i<n; i++)
			sum += set[i];
         
         out.println(solve(set,n,sum));		 	
	}
	
	static int solve(int set[], int n, int sum)
	{
		List<Integer> valid_sum = utilSolve(set, n, sum);
		
		n = valid_sum.size();
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<n/2; i++)
		{
		   // (s2-s1) ** take absolute value because 
		   // may be s1 > s2 ** then it will give negative value
		   // s1 + s2 = sum; 
     	   // s2 - s1 =  sum - 2s1;
		   
		   int diff = (int)Math.abs(sum - 2 * valid_sum.get(i) /*s1*/);
		   if(diff < min)
			   min = diff;
		}
		
		return min;
	}
	
	static List<Integer> utilSolve(int set[], int n, int sum)
	{
		boolean dp[][] = new boolean[n+1][sum+1];
		
		List<Integer> valid_sum = new ArrayList<Integer>();
		valid_sum.add(0); //because sum = 0 is alway possible
		
		for(int i=0;i<n+1; i++)
			dp[i][0] = true;
		
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<sum+1; j++)
			{
				if(set[i-1] <= j)
					dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i-1]];
				else
					dp[i][j] = dp[i-1][j];
				
				if(dp[i][j] == true && i==n)
					valid_sum.add(j);
			}
		}
		
		return valid_sum;
	}
}