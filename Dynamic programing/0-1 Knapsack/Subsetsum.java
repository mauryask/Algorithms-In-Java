// setset sum problem
// dynamic programming
 
import static java.lang.System.*;

public class Subsetsum 
{		
	public static void main(String [] srga)
	{
		int set[] =  {2,3,4,5,7,9};
		int n = 6;
		int sum = 9;
		
		out.println(topDown(set,n,sum));
	}
	
	/**
	* Recursive Approach
	* Worst Approach
	* Time Complexity : O(2^n);
	* Space Complexity : Height of the recursion tree
	*/	
		
	static boolean recursive(int set[], int n, int sum)
	{
		if(sum == 0)
			return true;
		if(sum != 0 && n==0)
			return false;
		
		if(sum >= set[n-1])
			return (recursive(set,n-1,sum-set[n-1]) || recursive(set, n-1, sum));
		else
			return recursive(set,n-1, sum);
	}
	
	/**
	* Bottom Up Approach (Dynamic Programming)
	* Best Approach
	* Time Complexity : O(n * sum);
	* Space Complexity : O(n * sum)
	*/	
	
	static boolean topDown(int set[], int n, int sum)
	{
		boolean dp[][] = new boolean[n+1][sum+1];
		
		for(int i=0; i<n+1; i++)
		{
			dp[i][0] = true;
		}
		
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=1; j<sum+1; j++)
			{
				if(set[i-1] <= j)
					dp[i][j] = dp[i-1][j-set[i-1]] || dp[i-1][j];
				else if(set[i-1] > j)
					dp[i][j] = dp[i-1][j];
			}
		}
		
        // you can print the subset if you want
		printSubset(set, dp, n, sum);
		
		return  dp[n][sum];
	}
	
	// Printing the subset
	static void printSubset(int set[], boolean dp[][],int n, int total)
	{
		String s = "";
		
		if(dp[n][total])
		{
			int i = n-1;
			int j = total;
			
			while(i!=0 || j!=0)
			{
				if(dp[i][j])
					i--;
				else
				{
					s = set[i] +" "+ s;
					j-= set[i];
				}
			}
	   }
	   
	   out.println(s);
	}
}