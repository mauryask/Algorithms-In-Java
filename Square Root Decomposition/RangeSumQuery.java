/*
* T(n): O(sqrt(n))
* S(n): O(sqrt(n))
*/
import java.util.*;
import static java.lang.System.*;

public class RangeSumQuery 
{	 
	int sol[];
    int len;
	
    RangeSumQuery(int n)
	{	    		
		len = (int)Math.sqrt(n);		
		sol = new int[len+1];
	}	
     
	//Precomputing the sum for each sqrt(n) size block 
	private void compute(int[] A, int n)
	{
		for(int i=0; i<n; i++)
		  sol[i/len] += A[i];		
	}	

    private int getSum(int A[], int l, int r)
	{
		int sum = 0;
		
        for(int i=l; i<=r;)
		{
			/*
			* i%len == 0 : Indicates that it is the starting of some block
			* i+len-1 <= r: Indicates that the block is within the range of 'r'
 			*/
			if(i%len == 0 && i+len-1 <= r)
			{
				sum += sol[i/len]; // Add the precomputed answer
				i += len; //Move to next bock dircetly
			}
			else //Handling partially overlaping bocks
			{
				sum += A[i];
				i++;
			}
		}

		return sum;		
	}

	public static void main(String [] args)
	{
		int A[] = {10,2,5,8,9,6,3,5,7,8,9,5,4,1,2,5,6};		
		RangeSumQuery rq = new RangeSumQuery(A.length);
		rq.compute(A, A.length);
		out.println(rq.getSum(A, 5, 14));		
	}
}



