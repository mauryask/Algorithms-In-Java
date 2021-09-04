/*
* Time complexity: O(n)
* Space compeiexity: O(n)
******************
Variable size window
*/

import static java.lang.System.*;
import java.util.*;

public class LongestSubstringWithKUniqueCharacters
{
	static int getLongestSubString(String str, int n)
	{
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, j=0;
		int maxLen = 0;
		
		while(j<n)
		{
			   char ch = str.charAt(j);
			   
			   map.put(ch, map.getOrDefault(ch, 0)+1);
			   
			   if(map.size() == j-i+1)
				  maxLen =  Math.max(maxLen, j-i+1);
			  
			  else if(map.size() < j-i+1)
			  {
				  while(map.size() < j-i+1)
				  {
					ch =  str.charAt(i);
					map.replace(ch, map.get(ch)-1);
					if(map.get(ch) == 0)
						map.remove(ch);
					i++;  
				  }	
			  }
				
			j++;
		}
		
		return maxLen;
	}
	
	public static void main(String [] args)
	{
		String str = "geeksforgeeks";
		int n = str.length();
		
		out.println(getLongestSubString(str, n));
	}
}