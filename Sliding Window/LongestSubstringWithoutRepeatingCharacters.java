/*
* Time complexity: O(n)
* Space compeiexity: O(n)
******************
Variable size window
**********
* Without repeating characters means
* in the window all charcaters must be
* unique i.e. number of characters in 
* the map should be equal
* to the window size (hence all the characters of the window
* is unique)
****
Idea: 
* In window there will be unique characters
* if and only if window size is equal to the map size
****
https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
*/

import static java.lang.System.*;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters
{
	static int getLongestSubString(String str, int n)
	{
		/*
		* Map is used to keep track of number
		* of unique characters in the window
		*/
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, j=0;
		int maxLen = 0;
		
		while(j<n)
		{
			   char ch = str.charAt(j);
			   
			   map.put(ch, map.getOrDefault(ch, 0)+1);
			   
			   if(map.size() == j-i+1)
				  maxLen =  Math.max(maxLen, j-i+1);
			  
			  /*
			  * If map size is less than window size
			  * means some character has been repeated
			  * so start removing the charactres from left
			  * until all the characters in the window
			  * are unique thats what we wanted
			  */
			  //this runs only for repeated charter not always hence: overall time complexity is going to be O(n)
				  while(map.size() < j-i+1)
				  {
					ch =  str.charAt(i);
					map.replace(ch, map.get(ch)-1);
					if(map.get(ch) == 0)
						map.remove(ch);
					i++;  
				  }					
			j++;
		}
		
		return maxLen;
	}
	
	// Best approach 
	// T(n) : O(n)
	// S(n) : O(n)

	sttaic int longestUniqueSubstr(String s) {
       int n = s.length();
       int i = 0;
       int max = 0;
       HashMap<Character, Integer> map = new HashMap<>();
       
       for(int j=0; j<n; j++){
           char ch = s.charAt(j);
           
		   // Skip the first occurance of the duplicate character
           if(map.containsKey(ch)){
			   // We are taking max here of the below two
			   // Casuse the i might already be ahead of the duplicate character encountered
			   // For example in 'geeksforgeeks' this particular example 
			   // When i points to second 'e' and later duplicate charcater 'g'
               // encountred then taking only max.get(ch) + 1 will give incorrect result as i is already ahead of this
               i = Math.max(i, map.get(ch) + 1);
           }
           
		   // Put the indnx of the characters
           map.put(ch, j);
           max = Math.max(max, j-i+1);
       } 
       
       return max;
    }
	
	/*
	* T(n) : O(n*n)
	* S(n) : O(n)
	*/
	
	static int bruteForce(String str, int n)
	{
		int maxLen = Integer.MIN_VALUE;
		
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++)
		{
			for(int j=i; j<n; j++)
			{
				char ch = str.charAt(j);
				
				map.put(ch, map.getOrDefault(ch, 0)+1);
				
				if(map.size() == j-i+1)
					maxLen = Math.max(maxLen, j-i+1);
				else if(map.size() < j-i+1)
					break;
			}
			
			map.clear();
		}
		
		return maxLen;
	}
	
	public static void main(String [] args)
	{
		String str = "geeksforgeeks";
		int n = str.length();
		
		//out.println(getLongestSubString(str, n));
		out.println(bruteForce(str, n));
	}
}