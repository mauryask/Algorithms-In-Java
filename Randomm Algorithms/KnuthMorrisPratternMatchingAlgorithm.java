import static java.lang.System.*;
import java.util.*;

/*
* T(n) : O(m*n)
* S(n) : O(1)
*/
public class KnuthMorrisPratternMatchingAlgorithm 
{
	static boolean bruteForce(String s1, String s2, int m, int n)
	{
		if(m < n)
			return false;
		
		if(m == 0 && n == 0)
			return true;
		
		int i = 0;
		int j = 0;
		
		while(i<m)
		{
			
		  // if Ai matches the first character of the gien 
		  // patternn string go inside the if block
		  if(s1.charAt(i) == s2.charAt(j))
		  { 
			 int k = i;
			 
		     while(j<n && k<m && s1.charAt(k) == s2.charAt(j))
			 {
				 k++;
				 j++;
			 }
			 
			 // if j becomes to n it means we found the required 
			 // pattern and return true
			 if(j == n)
				 return true;
		  }
		  // Ai is not matching with first character of pattern 
		  // increase i
		  i++;
		}
		
		return false;
	}
	
	static boolean knuthMorris(String s1, String s2, int m, int n)
	{
		// Creating the pie table 
		Map<Character, Integer> map = new HashMap<>();
		int pie[] = new int[n+1];
		
		for(int i=0; i<n; i++)
		{
			char ch = s2.charAt(i);
			if(!map.containsKey(ch))
			{
				map.put(ch, i);
				pie[i] = 0;
			}
			else
			{
				pie[i] = map.get(ch) + 1;
				map.replace(ch, map.get(ch)+1);				
			}
		}
					
		 int j = -1;
		 int i = 0;
		 int start = 0;
		 boolean flag = false;
		 
		 while(i<m)
		 {
			 char ch = s1.charAt(i);
			 
			 if(ch == s2.charAt(j+1))
			 {
				if(!flag) 
				{
					start = i;
					flag = true;
				}
				 i++;
				 j++;
			 }
			 else
			 {
                 if(j == -1)
					i++;
                 else 
					j = pie[j]-1;
                 flag = false;				
			 }
			 
			 if(j == n-1)
			 {
				 out.println("pattern found at: " + start);
				 return true;
			 }
		 }
		 
		 return false;
	}
	
	public static void main(String [] args)
	{
		String s1 = "CDABDEABCDAB";
		String s2 = "ABCDAB";
		
		int m = s1.length();
		int n = s2.length();
		
		out.println(knuthMorris(s1, s2, m , n));
		//out.println(bruteForce(s1, s2, m, n));
	}
}