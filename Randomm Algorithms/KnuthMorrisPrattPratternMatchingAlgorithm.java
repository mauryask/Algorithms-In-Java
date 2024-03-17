/*
* Read more about proper prefix and proper suffix  
* and LPS https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
*/
import static java.lang.System.*;
import java.util.*;

/*
* T(n) : O(m*n)
* S(n) : O(1)
*/
public class KnuthMorrisPrattPratternMatchingAlgorithm
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
	
	//See the file KMPSearchBestWay.java (for best implementation)
	static boolean knuthMorris(String s1, String s2, int m, int n)
	{
		/* Creating the lps table */
		Map<Character, Integer> map = new HashMap<>();
		
		/*
		* LPS : Longest proper prefix which is also suffix
		*/
		
		int lps[] = new int[n+1];
		
		for(int i=0; i<n; i++)
		{
			char ch = s2.charAt(i);
			if(!map.containsKey(ch))
			{
				map.put(ch, i);
				lps[i] = 0;
			}
			else
			{
				lps[i] = map.get(ch) + 1;
				map.replace(ch, map.get(ch)+1);				
			}
		}
		
		
		for(int x: lps)
			out.print(x+" ");
		out.println();
					
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
					j = lps[j]-1;
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
	
	//Using sliding window
	//T(n) : O(n*m)
	//S(n) : O(m)
	//Bettre than brute force
	
	static int slidingWindow(String s1, String s2)
	{
		Map<Character, Integer> map = new HashMap<>();
		int m = s2.length();
		int n = s1.length();
		
		for(int i=0; i<m; i++)
		{
			char ch = s2.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		int count = map.size();
		int i=0; 
		int j=0;
		int start = 0;
		
		while(j < n)
		{
			char ch = s1.charAt(j);
			
			if(map.containsKey(ch))
			{
				map.replace(ch, map.get(ch)-1);
				if(map.get(ch) == 0)
				   count--;
			}
						
			while(count == 0)
			{
				if(j-i+1 == m && s1.substring(i, j+1).equals(s2))
					start = i;
				
				ch = s1.charAt(i);
				
				if(map.containsKey(ch))
				{
					boolean isZero = map.get(ch) == 0 ? true : false;
					map.replace(ch, map.get(ch)+1);					
					
					if(isZero)
						count++;
				}
				
				i++;
			}
			
			j++;
		}
		
		return start;
	}
	
	static int[] getLps(String s2, int n)
	{
		int lps[] =  new int[n];
		
		if(n == 1)
			return lps;
		int i=0, j=1;
		
		while(j<n)
		{
			if(s2.charAt(i) == s2.charAt(j))
		    {
				lps[j] = i+1;
				i++;
				j++;
			}
			else if(i==0 && s2.charAt(i) != s2.charAt(j))
				j++;
			else if(i != 0 && s2.charAt(i) != s2.charAt(j))
				i = lps[i-1];			
		}

        return lps;		
	}
	
	static void betterSolution(String s1, String s2)
	{
		int m = s1.length();
		int n = s2.length();
		
		if(n == 0)
		{
			out.println("Matach found at: -1");
			return;
		}
		
		int lps[] =  getLps(s2, n);				
		
		for(int x : lps)
			out.print(x+" ");
		
	}
	
	public static void main(String [] args)
	{
		String s1 = "AABAACAABAA";
		String s2 = "AABAACAABAA";
		
		int m = s1.length();
		int n = s2.length();
		
		//out.println(knuthMorris(s1, s2, m , n));
		//out.println(bruteForce(s1, s2, m, n));
		
	    betterSolution(s1, s2);
	}
}