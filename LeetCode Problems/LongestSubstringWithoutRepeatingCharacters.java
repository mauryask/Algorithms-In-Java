// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
// #3
import java.util.*; 
  
public class LongestSubstringWithoutRepeatingCharacters
{   
   // O(n^2) solution
   // not that much better 
   // but working for all test cases in leet code
   
	public static int method1(String str) 
	{ 
		int n = str.length(); 
		int max = 0; 
		
		for(int i = 0; i < n; i++) 
		{ 
	        if((n-i)<=max)
				break;
			Map<Character, Boolean> map = new HashMap<>(26);
			for(int j = i; j < n; j++) 
			{ 
				if (map.containsKey(str.charAt(j))) 
					break; 
				else
				{ 
					max = Math.max(max, j - i + 1); 
					map.put(str.charAt(j), false); 
				} 
			} 
		} 
		return max; 
	} 
	
	// O(n) -- solution
	static int method2(String str)
	{
		int n = str.length();
		
		int i = 0;
		int max = 0;
		int charPos[] = new int[256];
		Arrays.fill(charPos, -1);
		
		for(int j=0;j<n;j++)
		{
			i = Math.max(i, charPos[str.charAt(j)]+1);
			max = Math.max(max, j-i+1);
		    charPos[str.charAt(j)] = j;	
		}
		
		return max;
	}
  
	public static void main(String[] args) 
	{ 
		String str = "abcdefghijklmnopqrstuvwxyz";   
		int len = method2(str); 
		System.out.println(len); 
	} 
} 