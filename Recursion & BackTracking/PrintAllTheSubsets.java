/*
* Printing all the subsets of 
* given String or Array
* T(n) = O(2^n)
* S(n) = O(1)
*/ 

import static java.lang.System.*;
import java.util.*;

public class PrintAllTheSubsets
{	
   static void printSubset(String str, String output,int start,
   int end)
   {
	   if(start > end)
	   {
           out.println("["+output+"]");
		   return;
	   }
	   
	   printSubset(str, output, start+1, end);
	   printSubset(str, output+str.charAt(start),
	   start+1, end);
   }

   public static void main(String [] args)
   {
       /*
	   * Aditya Verma version
	   */	 
	   
	   String str = "abc";
	   int n = str.length();
	   printSubset(str, "", 0, n-1);
	    
		
	   /*
	   * Leet code version
	   */
	   /*int A[]  = {1,2};
	   int n = A.length;
       printSubsetLeetCode(A, n);*/
   }
   
   /*
   * Print all the subsets
   * T(n) : O(2*n)
   * S(n) : O(2*n)
   */
   static void printSubsetLeetCode(int[] A, int n)
   {
	   List<List<Integer>> result = new ArrayList<List<Integer>>();
       List<Integer> list = new ArrayList<>();
       getSubset(A, list, result, n);
	   out.println(result);
   }
   
   static void getSubset(int[] A, List<Integer> output, 
                  List<List<Integer>> result, int n)
   {
	   if(n <= 0)
	   {
		   result.add(output);
		   return;
	   }
	   
	   getSubset(A, output,result, n-1);
	   output = new ArrayList<>(output);
       output.add(A[n-1]);
	   getSubset(A, output,result, n-1);
   }
}