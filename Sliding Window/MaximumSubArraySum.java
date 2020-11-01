import static java.lang.System.*;

public class MaximumSubArraySum 
{
	public static void main(String [] args)
	{
		int A[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int n =  A.length;
		out.println(solve(A, n));
	}
	
	static int solve(int A[], int n)
	{
		int sum = 0;
		int max = 0;
		int k = 0;
		
		for(int i=0; i<n; i++)
		{
			for(int j=i ;j<n; j++)
			{
				
			}
		}
	}
}