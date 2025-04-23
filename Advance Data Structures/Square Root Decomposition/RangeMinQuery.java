/*
* T(n): O(sqrt(n))
* S(n): O(sqrt(n))
*/
import java.util.*;
import static java.lang.System.*;

public class RangeMinQuery
{	 	
	int sol[];
    int len;
	
    RangeMinQuery(int n)
	{	    		
		len = (int)Math.sqrt(n);		
		sol = new int[len+1];
		Arrays.fill(sol, Integer.MAX_VALUE);
	}	
     
	//Precomputing the sum for each sqrt(n) size block 
	private void compute(int[] A, int n)
	{
		for(int i=0; i<n; i++)
		  sol[i/len] = (int)Math.min(sol[i/len], A[i]);		
	}	

    private int getMin(int A[], int l, int r)
	{
		int min = Integer.MAX_VALUE;
		
        for(int i=l; i<=r;)
		{
			/*
			* i%len == 0 : Indicates that it is the starting of some block
			* i+len-1 <= r: Indicates that the block is within the range of 'r'
 			*/
			if(i%len == 0 && i+len-1 <= r)
			{
				min = Math.min(sol[i/len], min); // Add the precomputed answer
				i += len; //Move to next bock dircetly
			}
			else //Handling partially overlaping bocks
			{
			    min = Math.min(A[i], min);
				i++;
			}
		}

		return min;		
	}

	public static void main(String [] args)
	{
		int A[] = {10,2,5,8,9,6,3,5,7,8,9,5,4,1,2,5,6};		
		RangeMinQuery rq = new RangeMinQuery(A.length);
		rq.compute(A, A.length);
		out.println(rq.getMin(A, 7, 9));		
	}
}



