/*
* Read more about proper prefix and proper suffix  
* and LPS https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
*/
import static java.lang.System.*;
import java.util.*;

/*
* T(n) : O(m + n)
* S(n) : O(n)
*/
public class KMPSearchBestWay
{	
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
	
	static int isPatternFound(String s1, String s2, int m, int n, int lps[])
	{
		int i = 0;
		int j = 0;
		
		boolean isStartSet = false;
		int start = -1;
		
		while(j<m && i<n)
		{
			if(s2.charAt(i) == s1.charAt(j))
			{
				if(!isStartSet)
				{  
			        //This is the index of first matching point
					start = j-i;
					isStartSet = true;
				}
				
				i++;
				j++;				
			}
			else if(i == 0 && s2.charAt(i) != s1.charAt(j))
			{
				j++;
				isStartSet = false;
			}
			else if(i != 0 && s2.charAt(i) != s1.charAt(j))
			{
				i = lps[i-1];
				isStartSet = false;
			}
		}
        //If i == n : means the pattern found in the given text string
        return i == n ? start : -1;		
	}
	
	static void kmpSearch(String s1, String s2)
	{
		int m = s1.length();
		int n = s2.length();
		
		if(n == 0)
		{
			out.println("Matach found at: -1");
			return;
		}
		
		int lps[] =  getLps(s2, n);

        out.println(isPatterFound(s1, s2, m, n, lps)); 
	}
	
	public static void main(String [] args)
	{
		String s1 = "leetcode";
		String s2 = "leeto";
	    kmpSearch(s1, s2);
	}
}