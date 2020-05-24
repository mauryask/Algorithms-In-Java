/*
* 
* @ 0/1 knapsack problem 
* @ time complexity O(n*w) and O(2^n)
* @ choose one depending upon the value of w
* 
*/


class (0-1)KnapSackProblem
{
    public static void main(String args[] ) throws Exception {
        
    int w[] = {1, 2, 4}; //weight
    int p[] = {10, 12, 28}; //profit
    int c = 6; //the capacity of the knapsack
    
    ks(w,p,c);
    
    }
    
    static void ks(int w[], int p[], int c)
    {
    	
    	int n = w.length; //finding number of the objects
    	
    	//table to memorize the max profits
    	int table[][] = new int[n+1][c+1];
    	   	
    	
    	//putting horizontal row to zero
    	
    	for(int i=0; i<c+1; i++)
    	{
    		table[0][i] = 0;
    	}
    	
    	for(int i=1; i<n+1; i++)
    	{
    		//putting vertical columns to zero
    		
    		table[i][1] = 0;
    		
    		for(int j=1 ; j<c+1; j++ )
    		{
    			if(w[i-1] <= j && table[i-1][j-w[i-1]] +p[i-1] > table[i-1][j])
    			{
    				table[i][j] = table[i-1][j-w[i-1]] +p[i-1];
    			}
    			else
    			{
    				table[i][j] = table[i-1][j];
    			}
    		}
    	}
    
    	
    	//the profit table 
    	
    	for(int i=0; i<n+1; i++)
    	{
    		for(int j=0; j<c+1; j++)
    		{
    			System.out.print(table[i][j]+"   ");
    		}
    		System.out.println();
    		
    	}
    	
    	System.out.println("\n");
    	
    	//maximum profit table[n][c]
    	System.out.println("Maximum Profit: "+table[n][c]);
    }
}
