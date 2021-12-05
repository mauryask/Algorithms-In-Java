/*
* Time complexity  : O(n)
* Space complexity : O(n)
**
* Note: Works with all the test cases 
* in leet code
**
https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
*/

import static java.lang.System.*;
import java.util.*;

public class FindSmallestWindow
{
    static int minWindow(String s1, String s2, int m, int n)
    {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<n; i++)
        {
            char ch = s2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int count = map.size();
        int minLength = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int start  = 0;
        int end = 0;
        
        while(j<m)
        {
            char ch = s1.charAt(j);
            
            if(map.containsKey(ch))
            {
               map.replace(ch, map.get(ch)-1);
               
               if(map.get(ch) == 0)
                   count--;
               
               while(count == 0)
               {
                   if(minLength > j-i+1)
                   {
                       minLength = j-i+1;
                       start = i;
                       end = j;
                   }                     
                   
                   ch = s1.charAt(i);
                   
                   if(map.containsKey(ch))
                   {
                       boolean isZero = map.get(ch) == 0 ? true : false;
                       map.replace(ch, map.get(ch)+1);
                       boolean isNonZero = map.get(ch) != 0 ? true : false;
                       
                       if(isZero && isNonZero)
                           count++;
                   }
                    
                   i++;
               }
            }
            
            j++;
        }

        out.println(s1.substring(start, end+1));
        return minLength;
    }
    
	
	/*
	* T(n) : O(n*n*k) > if there are m characters int the m1 at any time
	* S(n) : O(n)
	*/	
			
    static int bruteForce(String s1, String s2)
	{
		int n = s1.length();
		
		Map<Character, Integer> map = new HashMap<>();	
		Map<Character, Integer> m1 = new HashMap<>();
		
		int minLength = Integer.MAX_VALUE;

		for(int i=0; i<s2.length(); i++)
		{
			char ch = s2.charAt(i);
			m1.put(ch, m1.getOrDefault(ch, 0)+1);
		}
		
		for(int i=0; i<n; i++)
		{
			for(int j=i; j<n; j++)
			{
				char ch = s1.charAt(j);
				map.put(ch, map.getOrDefault(ch, 0)+1);
			      
				  // if window size is less than the 
				  // length of the string-2, you can never
				  // find a window containing 
				  // all the chracters of s2
				  
				   if(j-i+1 < s2.length())
					   continue;
				  
					boolean flag = true;
					
					for(Map.Entry<Character, Integer> m : m1.entrySet())
					{
						char key = m.getKey();
						int value  = m.getValue();
						
						if(map.getOrDefault(key, 0) != value)
						{
							flag = false;
							break;
						}
					}
					
					/*
					* If this sub-array contains same number of 
					* characters then update min length
					*/
					if(flag)
					{
						minLength = Math.min(minLength, j-i+1);
						/*
						* Once found a window 
						* just break becuse the further 
						* windows are going to be larger
						* than the current one
						*/
						break;
					}
			}
			
			map.clear();
		}
		
		return minLength;
	}
	
    public static void main(String [] args)
    {       
        String s1 = "this is a test string";
        String s2 = "tist";
        int m = s1.length();
        int n = s2.length();
        
        out.println(minWindow(s1, s2, m, n));
    }	
}

