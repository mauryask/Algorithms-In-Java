// Longest palindromic substring 
// Similiar queation is there 
// counting total number of palindromic substrings
 
import static java.lang.System.*;
import java.util.*;
public class LongestPalindromicSubstring
{
	 public static void main(String [] args)
	 {
		 out.println(solve2("test"));
	 }
	
	
	 /*
	 * Brute Force Solution
	 * Time Complexity : O(n^3) 
	 * Space Complexity : O(1)
	 * in leet code 75% test cases are passed
	 * good but not the best solution
	 */
	 
	 public static void solve(String str) 
	 {
       int n = str.length();
	   int max = Integer.MIN_VALUE;
	   String rslt = "";
	   for(int i=0; i<n ; i++) // O(n)
	   {
		   if(n-i < max)
			   break;
		    
		   for(int j=i; j<n; j++) // O(n)
		   {
			   String s = str.substring(i,j+1); // O(n)
			   if(isPalin(s))
			   {
				   int len = s.length();
				   if(max < len)
				   {
					   max = len;
					   rslt = s;
				   }
			   }
		   }
	   }
	   out.println(rslt);
     }
	 
	 static boolean isPalin(String str)
	 {
		 String s = new StringBuilder(str).reverse().toString();
		 return s.equals(str) ? true : false;
	 }
	 
	 
	 /*
	 * Time Complexity : O(n^2) 
	 * Space Complexity : O(n^2)
	 * Better but not Best Solution
	 * O(n) solution is also there : Manacher's Algorithm
	 */
	 
	 static String solve2(String str)
	 {
		 int n = str.length();
		 if(n <= 1)
			 return str;
		
		 int l = 0, l1 = 0, l2 = 0;
		 int max = Integer.MIN_VALUE;
		 int start = 0, end = 0;
		 
		 for(int i=0; i< n ; i++)
		 {
			 l1 = expand(str, i, i, n);
			 l2 = expand(str, i, i+1, n);
			 l = Math.max(l1, l2);
			 
			if(max < l)
			{
				max = l;
			    start = i - (l-1)/2;
				end  = i + l/2;
			}
		 }
		 
		 return str.substring(start, end+1);
	 }
	 
	 static int expand(String s, int i, int j, int n)
	 {
		 while(i >=0 && j<n)
		 {
			 if(s.charAt(i) == s.charAt(j))
			 {
				 i--;
				 j++;
			 }
			 else
				 break;
		 }
		 
		 return j-1-i; //length of the substring 
	 }
}