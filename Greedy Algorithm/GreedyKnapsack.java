//greedy knapsack algorithm (or fractional knapsack algorithm)
//time complexity depends on sorting algorithm being used
//here in case of insertion sort time complexity is : O(n^2)
//in case of merge sort time complexity is : O(n * log n)

public class Test
{
	public static void main(String [] args)
	{
		int p[] = {25, 24, 15}; //profit array
		int w[] = {18, 15, 10}; //weight array
		int m = 20; //size of the knapsack
		
		greedyKnapsack(p ,w, m);
	}
	
	static void greedyKnapsack(int p[], int w[], int m)
	{
		float pw []= new float[p.length];
		
	    for(int i=0; i<p.length; i++)
	    {
	    	pw[i] = (float) p[i] / (float)w[i];
	    }
	    
	    //sorting the objects in non-increasing order of the p/w ratio	    
	    sortObjects(pw, p,w);
	    
	    float profit = 0.0f; //total profit
	    int i; 
	    for(i=0; i<p.length; i++)
	    {
	    	if(m > 0 && w[i] < m)
	    	{
	    		m = m - w[i];
	    		profit += p[i];
	    	}
	    	else
	    		break;
	    }
	    
	    if(m > 0)
	    {
	    	profit = profit + ((float)p[i] / w[i]) * m;
	    }
	    
	    System.out.println(profit);
	}
	
	static void sortObjects(float pw[], int p[], int w[]) 
	{
		float temp;
		int p_temp;
		int w_temp;
		int i, j;
		
		for(i=1 ;i <p.length; i++)
		{
			temp = pw[i];
			p_temp = p[i];
			w_temp  = w[i];
			for(j=(i-1); j>=0 && temp > pw[j]; j--)
			{
				pw[j+1] = pw[j];
				p[j+1]  = p[j];
				w[j+1]  = w[j];
			}
			
			pw[j+1] = temp;
			p[j+1]  = p_temp;
			w[j+1]  = w_temp;
		}
		
	}
}