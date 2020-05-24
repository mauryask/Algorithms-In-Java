
public class BottomUpMatrixChain
{
	public static void main(String [] args)
	{
		//let there is 4 matrices
		int p [] = {2,3,4,5,6}; //dimensions (p0,p1,p2,p3,p4,p5,p6)
        matrix_chain(p);		
 	}
 	
   static void matrix_chain(int p[])
   {
	  //number of matrices;
      int n = p.length - 1; 
	  //matrix that stores the cost(table M[1..n, 1..n])
	  int m[][] = new int[n][n]; 
	  // matrix that stores the value of 'k' splitting index (table M[1..n-1, 2..n])
	  //but here for convenience we have taken S[1..n, 1...n]
	  int s[][] = new int[n][n]; 
	 
   	 for(int i=0; i<n; i++)
	  {
		m[i][i] = 0; //put 0 if 'i==j'		
	  }
	  //cell that holds the result of multiplication of l matrices 
	  for(int l=2; l<=n; l++) 
	  {

		  for(int i=0 ; i<(n-l+1) ; i++) 
		  {
		   int j = i+l-1;
		   m[i][j] = Integer.MAX_VALUE; //put infinite
		   for(int k=i; k<j; k++)
		   {
			   int q = m[i][k] + m[k+1][j] + (p[i] * p[k+1] * p[j+1]);
			   if(q < m[i][j])
			   {
				   m[i][j] = q;
			       s[i][j] = k;
			   }	   
		   }
		  }
	  }
	  
	  
	  //printing the cost matrix
	  for(int i=0; i<n; i++)
	  {
		  for(int j=0; j<n; j++)
		  {
			  System.out.print(m[i][j]+"\t");
		  }
		  
		  System.out.println();
	  }
	  
	  System.out.println();
	  System.out.println();

	  
	  //printing the k matrix
	  for(int i=0; i<n; i++)
	  {
		  for(int j=0; j<n; j++)
		  {
			  System.out.print(s[i][j]+"  ");
		  }
		  
		  System.out.println();
	  }
	  
	  
	   System.out.println();

	  printOptimal(s,0,n-1);
	   
   }	  
    
	static void printOptimal(int s[][],int i, int j)
	{
			
		if(i==j)
			System.out.print("A"+(i+1));
		else
		{
			System.out.print("(");
			printOptimal(s,i,s[i][j]);
			printOptimal(s,s[i][j]+1,j);
			System.out.print(")");
		}
	}	
 
}