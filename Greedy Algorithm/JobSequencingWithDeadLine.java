//JobSequencing with deadline
//Algorithm uses greedy approach
//time complexity in case of insertion sort: O(n^2)
//in case of merge sort time complexity is 
//(it helps a little bit not much) : O(n^2)

public class JobSequencingWithDeadLine
{
	public static void main(String [] args)
	  {
	     int P[] = {2,4,3,1,10}; //profit
		 int D[] = {3,3,3,4,4}; //deadline
		 
	     int md  = findMaxDeadLine(D);//finding max deadline
	     
	     int S[] = new int[md]; // array for assigning the job
	     
	     sortProfitAndDeadLine(P, D); //sorting the profit and deadline arrays 
	     
	     int profit  = jobSequencingWithDeadLine(P, D, S, md);
	     
	     System.out.println(profit);
	  }
	
	
	static int jobSequencingWithDeadLine(int P[], int D[], int S[], int max) 
	{
		int profit = 0;
	    for(int i=0; i<P.length; i++)
	    {
	    	for(int j=D[i]-1; j>=0; j--) //D[i]-1 because indexing is taken from 0
	    	{
	    		if(S[j] == 0)
	    		{
	    			S[j] = Integer.MAX_VALUE;
	    			profit += P[i];
	    			break;
	    		}
	    	}
	    }
	    
	    return profit;
	}
	
	static void sortProfitAndDeadLine(int P[], int D[])
	{
		int p_temp;
		int d_temp;
		int i,j;
		
		for(i=1; i<P.length; i++)
		{
			p_temp = P[i];
			d_temp = D[i];
			for(j= (i-1); j>=0 && p_temp > P[j]; j--)
			{
				P[j+1] = P[j];
				D[j+1] = D[j];
			}
			
			P[j+1] = p_temp;
			D[j+1] = d_temp;					
		}
	}

		static int findMaxDeadLine(int D[])
		{
			int max = D[0];
			for(int i=1; i<D.length; i++)
			{
				if(max < D[i])
					max  = D[i];
			}
			
			return max;
		}		
}