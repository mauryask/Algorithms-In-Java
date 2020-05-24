package com.pnstech;

public class LongestCommonSubsequences {

	public static void main(String[] args) {
		
		String x = "ABCBDAB"; // length = 7
		String y = "BDCABA";  // length = 6
		
		LCS(x,y);

	}

	
	static void LCS(String x, String y)
	{
		int m = x.length();
		int n = y.length();
		
		int C[][] = new int[m+1][n+1]; //length of subsequences
		String B[][] = new String[m][n];//stores the symbols to evaluate the optimal solution
		
		for(int i=0; i<=m ; i++)
			C[i][0] = 0;			
		for(int j=1; j<=n ; j++)
			C[0][j] = 0;
 
		
		for(int i=1; i<=m; i++)
		{
			for(int j=1; j<=n; j++)
			{
				//comparing character one by one starting index is taken as 0
				if(x.charAt(i-1) == y.charAt(j-1)) 
				{
					C[i][j] = 1 + C[i-1][j-1];
					B[i-1][j-1] = "\\";
				}
				else if(C[i-1][j] >= C[i][j-1])
				{
					C[i][j] = C[i-1][j];
					B[i-1][j-1] = "|";
				}
				else
				{
					C[i][j] = C[i][j-1];
					B[i-1][j-1] = "<-";
				}
			}
		}
		
		
	 //printing the table containing the lengths of the the subsequences
		for(int j=0; j<=m ;j++)
		{
			for(int k=0; k<=n; k++)
			{
				System.out.print(C[j][k]+" ");
			}
			System.out.println();
		}
		
		//print the optimal solution using the recursion (using another table)
		//printLCS(B, x, m-1, n-1);
		
		
		//printing the optimal solution (without using second table)
		//here it reduces the time complexity a little-bit
		System.out.println();
		//here C[m][n] is the value of longest common subsequence 
		printWithoutUsingTableB(C,x,y,C[m][n]);
		
	}
	
  //printing the optimal solution
	static void printLCS(String B[][],String x,int i,int j)
	{
		if(i==-1 || j==-1)
			return;
		if(B[i][j] == "\\")
		{
			printLCS(B,x,i-1, j-1);
			System.out.print(x.charAt(i));
		}
		else if(B[i][j] == "|")
		{
			printLCS(B,x,i-1,j);
		}
		else
		{
		  printLCS(B,x,i,j-1);	
		}
	}

	
	static void printWithoutUsingTableB(int C[][],String X, String Y, int N)
	{
		//here n is the length of longest common subsequences
		int i = X.length(); // m
		int j = Y.length(); // n
		
		//this array stores the longest common subsequences
		char [] lcs = new char[N];  
		
		while(i>0 && j>0)
		{
			if(X.charAt(i-1) == Y.charAt(j-1))
			{
				lcs[N-1] = X.charAt(i-1);
				i--;
				j--;
				N--;
				
			}
			else if(C[i-1][j] >= C[i][j-1])
			{
				i--;
			}
			else
			{
				j--;
			}
		}
		
		//converting the character array to string
		String longest_sequence = new String(lcs);
			System.out.print(longest_sequence);		
	}
	
}
