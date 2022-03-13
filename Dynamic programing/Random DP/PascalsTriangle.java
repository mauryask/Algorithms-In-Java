import static java.lang.System.*;
import java.util.*;

public class PascalsTriangle 
{
	//  Dynamic programming 
	//  T(n) : O(n*n)
	//  S(n) : O(n*n)
	
	static void pascTri(int n, int[][] dp)
	{
	     for(int i=0; i<=n; i++)
		 {
			 for(int j=0; j<=i; j++)
			 {
				 if(j==0) // first column
					 dp[i][j] = 1;
				 else if(i==j) // main diagonal
					 dp[i][j] = 1;
				 else 
					 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			 }
		 }
	}
	
	// Brute force solution
	// Every term in pascals trianlge is: (nCr)
	// T(n) : O(n*n*n)
	// S(n) : O(n)
	
	static void bruteForce(int n)
	{
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=i; j++)
			{
				out.print((fact(i)/(fact(j) * fact(i-j))) + " ");
			}
			
			out.println();
		}
	}
	
	static int fact(int n)
	{
		if(n==0 || n==1)
			return 1;
		return n*fact(n-1);
	}
	
	public static void main(String [] args)
	{
		int n = 5;
		int dp[][] = new int[n+1][n+1];
		
		/*pascTri(n , dp);
		
		// print traingle
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=i; j++)
			{
				out.print(dp[i][j] + " ");
			}
			out.println();
		}*/
		
		bruteForce(n);
	}
}