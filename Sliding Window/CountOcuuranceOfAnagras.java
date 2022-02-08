/*
* Time complexity  : O(n*k)
* Space complexity : O(k) as the map
********************
** fixed size window
*/
import static java.lang.System.*;
import java.util.*;

public class CountOcuuranceOfAnagras
{
	static int anagramCount(String str, String pattern,
	int n,int k)
	{
		/*
		* this map conatins charcater 
		* count of pattern string
		*/
		
		Map<Character, Integer> map = new HashMap<>();
	
		for(int i = 0; i<k; i++)
		{
			char c1 = pattern.charAt(i);
			map.put(c1, map.getOrDefault(c1, 0)+1);
		}			
				
	    int i=0, j=0;
		int count = 0;
		
		/*
		* this map conatins charcater 
		* count of main string (str)
		*/		
		Map<Character, Integer> m1 = new HashMap<>();
		
		while(j<n)
		{
			char c2 = str.charAt(j);
			m1.put(c2, m1.getOrDefault(c2, 0)+1);
			
			if(j-i+1 == k)
			{
				boolean flag = true;
				
				/*
				*  Check if the window
				/* contains same charcaters
				/* in same amount or not
				*/
				for(Map.Entry<Character, Integer>
				m : map.entrySet())
				{
					char ch = m.getKey();
					int cnt = m.getValue();
					
					/*
					* If any charcater count 
					* is not same in m1 as in map
					* set flag false and terminate loop
					***********
					* Here getOrDefault() becasuse if element
					* is not pr4sent in m1 then it
					* will give null pointer exception
					*/
					
					if(m1.getOrDefault(ch, 0) != cnt)
					{
						flag = false;
						break;
					}
				}
				
				/*
				* if flag true means
				* the window contains same number of
				* character as in pattern
				*/
				
				if(flag)
					count++;
			
				char c3 = str.charAt(i);
				
				
				/*
				* Decrease the count of ith character
				* from m1 before sliding to the next window
				* ******************************
				* as we do int max sum sub array
				* sum = sum - Ai
				*/
				m1.replace(c3, m1.get(c3)-1);
				i++;
			}
			
			j++;
		}
			
		return count;
	}
	
	
	/**
	* T(n) = (n*k)
	* S(n) = O(k)
	*/
	
	static int bruteForce(String str, String pattern,
	int n, int k)
	{
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> m1;
		
		for(int i=0; i<k; i++)
		{
			char ch = pattern.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		int anagramCount = 0;
		
		for(int i=0; i<= n-k ; i++)
		{
			m1 = new HashMap<>();
		
			for(int j=i; j<i+k; j++)
			{
				char ch = str.charAt(j);
				m1.put(ch, m1.getOrDefault(ch, 0)+1);
			}

			boolean flag = true;
			
			for(Map.Entry<Character, Integer> m 
			: map.entrySet())
			{
				char key = m.getKey();
				int  value = m.getValue();
				
				/*
				* getOrDefault() here becasuse
				* if key is not present in m1
				* then it will retun null
				* as the resuolt null pointer exception
				* wil be thrown
				*/
				if(m1.getOrDefault(key, 0) != value)
				{
					flag = false;
					break;
				}
			}
			
			if(flag)
				anagramCount++;
		}
		
		return anagramCount;
	}
	
	public static void main(String [] args)
	{
		String str = "aababddeabaa";
		String pattern = "aaba";
		int k = pattern.length(); // window size
		int n = str.length();
		
		 out.println(anagramCount(str, pattern, n, k));
		//out.println(bruteForce(str, pattern, n, k));
	}
}