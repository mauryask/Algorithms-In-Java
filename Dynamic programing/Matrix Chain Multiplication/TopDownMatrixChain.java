
public class TopDownMatrixChain
 {
	public static void main(String[] args) {
		
		int p [] = {2,3,4,5};
		int n = p.length-1;
		int m[][] = new int[n][n];
		topDownMatrixChain(p,n,m);
		
		for(int i=0;i<n; i++)
		{
			for(int j=0;j<n; j++)
			{
				System.out.print(m[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
	
	static void topDownMatrixChain(int p[], int n, int m[][])
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				m[i][j] = Integer.MAX_VALUE;
			}
		}
		
		lookUpChain(m,p,0,n-1);
	}
	
	static int lookUpChain(int m[][], int p[], int i, int j) // O(n^3)
	{
		if(m[i][j] != Integer.MAX_VALUE) //checks if value is already computed then just return it
			return m[i][j];
		if(i==j)
			m[i][j] = 0;
		else
		{
			for(int k=i ;k<j; k++) //n-times
			{
				//O(n^2)
			   int q = lookUpChain(m, p, i, k) + lookUpChain(m, p,k+1,j) + p[i] * p[k+1] * p[j+1] ;	
			   if(q< m[i][j])
				   m[i][j] = q;			   
			}
		}
		
		return m[i][j];
	}

}
