/*
* T(n) : O(n^3)
* S(n) : O(n^2)
* Bottom-up dp
*/

import java.util.*;
import static java.lang.System.*;

public class Test
{		
	static boolean wordBreak(String str, Set<String> set)
	{
		int n = str.length();
		boolean dp[][] = new boolean[n+1][n+1];
				
		//This is special kind of looping 
        //That goes diagonally		
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n-i+1; j++)
			{
				int k = i+j-1;
				
				//Check if substring present in the dict.
				dp[j][k] = set.contains(str.substring(j-1, k));
				
                //If not present: check if its sub-parts are present in dict.
				for(int l=j; l<k && !dp[j][k]; l++)
					dp[j][k] = dp[j][l] && dp[l+1][k];
			}
		}
		
		return dp[1][n];
	}
	
	public static void main(String [] args)
	{
		Set<String> set = new HashSet<>();
		
		String word = "keice";//"ilikesamsung";
		//String word = "mypenmy";
			
		String[] words = { "mobile", "samsung",  "sam",  "sung", "ma",
                "mango",  "icecream", "and",  "go",   "i",
                "like",   "ice",      "cream" };
				
		//String words[] = {"my", "pen"};
  
		for(String w : words)
			set.add(w);

		out.println(wordBreak(word, set));
	}
}
