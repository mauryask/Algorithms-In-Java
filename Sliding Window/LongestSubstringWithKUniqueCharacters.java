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
			
			if(!map.containsKey(ch))
				map.put(ch, i);
			else 
			{
				maxLen = Math.max(maxLen, j-i);
				map.clear();
				i = j;
				map.put(str.charAt(i), i);
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