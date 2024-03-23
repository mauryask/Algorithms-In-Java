/*
* T(n) : O(n)
* S(n) : O(n)
* https://www.geeksforgeeks.org/count-distinct-subsequences/
*/

import static java.lang.System.*;
import java.util.*;

public class CountDistinctSubsequnces
{	
    static int distSubSeq(String str, int n)
	{
		int dp[] = new int[n+1];
		Map<Character, Integer> map = new HashMap<>();
		dp[0] = 1;
	    
		// these are indices of dp array
		for(int i=1; i<n+1; i++)
		{
			dp[i] = 2 * dp[i-1];
			char ch = str.charAt(i-1);
			
			// if charcater is repeated remove all the 
			// subsequnces just before the repeated character
			if(map.containsKey(ch))
			{
				int index = map.get(ch);
				dp[i] = dp[i] - dp[index-1];
			}
			
			map.put(ch, i);
		}
		
		return dp[n];
	}
	
	public static void main(String [] args)
	{
		String str = "ggg";
		int n = str.length();
		out.println(distSubSeq(str, n));
    }
}