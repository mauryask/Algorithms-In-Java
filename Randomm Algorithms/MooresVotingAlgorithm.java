/*
* T(n) : O(n)
* S(n) : O(1)
** Majority element
*/

import static java.lang.System.*;
import java.util.*;

public class MooresVotingAlgorithm 
{
	static int getMajEle(int[] A, int n)
    {
       int me = A[0];
       int count  = 1;

       for(int i=1; i<n; i++)
       {
           if(A[i] == me)
               count++;
           else
               count--;
           if(count == 0)
           {
               me = A[i];
               count = 1;
           }
       }
        
       count  = 0;
       for(int x : A)
       {
           if(x == me)
               count++;
       }           
       
       if(count > n/2)
           return me;
       return -1;
    }	
    
	public static void main(String [] args)
	{
		int A[] = {2,2,1,1,1,2,2};
	    int n =- A.length;
		
		out.println(getMajEle(A, n));
	}
}