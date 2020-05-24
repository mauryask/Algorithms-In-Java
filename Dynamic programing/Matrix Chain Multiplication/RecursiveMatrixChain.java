//recursive version of matrix-chain-multiplication
//it takes more time compare to tabular method

public class RecursiveMatrixChain 
{

   public static void main(String [] args)
   {
	   int p[] = {2,3,4,5};
	   int n = p.length-1;
	   int m[][]  = new int[n][n];
	   recursiveMatrixChain(p,0,2,m); 

	 for(int i = 0; i<n ;i++)
	 {
		 for(int j=0; j<n; j++)
		 {
			 System.out.print(m[i][j]+"\t");
		 }
		 System.out.println();
	 }	 
   }   
   
   static int recursiveMatrixChain(int p[], int i, int j, int m[][])
   {
	   if(i == j)
		return 0;
	    m[i][j] = Integer.MAX_VALUE;
	   
       for(int k=i; k<j; k++)
	   {
		   int q = recursiveMatrixChain(p,i,k,m) +
		   recursiveMatrixChain(p,k+1,j,m) +
		   p[i] * p[k+1] * p[j+1]; 
		   
	       if(q < m[i][j])
			   m[i][j] = q;
	   }
	   
	   return m[i][j];
   }
}