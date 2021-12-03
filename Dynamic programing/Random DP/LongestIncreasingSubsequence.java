import static java.lang.System.*;
import java.util.*;

public class LongestIncreasingSubsequence 
{
	// Brute force solution 
	// T(n) : O(n*n)
	// S(n) : O(n*n)
	// because we have to take here n List 
	// one in each iteration 
	
	 static void solve(int[] A, int n)
    {
        int maxLength = 0;
       
        for(int i=0; i<n-1; i++)
        {
            List<Integer> list = new ArrayList<>();
            list.add(A[i]);
            
            for(int j= i+1; j<n; j++)
            {
                if(A[i] < A[j])
                    list.add(A[j]);
            }
            
            maxLength = Math.max(maxLength, list.size());
        }
        
        out.println(maxLength);
    }
	
	// DP based solution  
	// T(n) : O(n*n)
	// S(n) : O(n)
	
	static void LIS(int[] A, int n)
	{
		int length[] = new int[n];
		int path[] = new int[n];
		Arrays.fill(length, 1);
		Arrays.fill(path, -1);
		
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(A[i] > A[j] && (1+length[j] > length[i]))
				{
						length[i] = 1 + length[j];
						path[i] = j;
				}
			}
		}
		
	  // printing the sequence 
	  // see the output from the end or store it 
	  // in a list from end
	  
	  int temp = n-1;
	  out.print(A[temp]+" ");
	  while(path[temp] != -1)
	  {
		  temp = path[temp];
		  out.print(A[temp]+" ");
	  }
	}
	
	public static void main(String [] args)
	{
		int A[] = {10,22,9,33,21,50,41,60,80};
		int n = A.length;
		LIS(A, n);
	}
}