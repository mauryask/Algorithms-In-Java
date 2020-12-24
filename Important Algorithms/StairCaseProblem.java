import static java.lang.System.*;

public class StairCaseProblem 
{
	public static void main(String [] args)
	{
		int n = 4; // total stairs
		int m = 2; // maz steps one can climb at once
		
		int dp[] = new int[n+1];
		dp[0] = 0; //0- way to reach 0 from 0
		dp[1] = 1; //1- way to reach 1 form 0
		
		out.println(solve(dp,m,n));
	}
	
	static int solve(int dp[], int m, int n)
	{
		for(int i=2; i<n+1; i++)
		{
			if(i<=m)
				dp[i] = dp[i-1] + dp[i-2] +1;
			else
				dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
}