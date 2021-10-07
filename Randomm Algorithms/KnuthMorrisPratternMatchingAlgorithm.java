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
	
	public static void main(String [] args)
	{
		String s1 = "AAAAAAAAAAAAAAAAAB";
		String s2 = "AAAAB";
		
		int m = s1.length();
		int n = s2.length();
		
		//knuthMorris(s1, s2, m , n);
		out.println(bruteForce(s1, s2, m, n));
	}
}