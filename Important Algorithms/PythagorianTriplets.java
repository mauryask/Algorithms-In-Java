// Question Number : #9

//  finding pythagorian triplets  i.e.
//  a^2 + b^2 = c^2 
//  T(n) = O(n^2)
//  S(n)  = O(n)


import static java.lang.System.*;
import java.util.*;
public class PythagorianTriplets 
{
	public static void main(String [] args)
	{
		int A[] =  new int[]{1,4,3,6,5};
		out.println(bruteForce(A));
	}
	
  // O(n^3) solution
  static boolean bruteForce(int A[])
  {
	  int n = A.length;
	  
	  for(int i=0; i<n; i++)
	  {
		  for(int j=i+1; j<n; j++)
		  {
			  for(int k=j+1; k<n; k++)
			  {
				  int x = A[i] * A[i];
				  int y = A[j] * A[j];
				  int z = A[k] * A[k];
				  
				  if(x+y == z || y+z == x || z+x == y)
					  return true;
			  }
		  }
	  }
	  
	  return false;
  }
	
	// O(n^2) solution
	static boolean isTripletExists(int A[])
	{
		int n = A.length;
		for(int i=0; i<n; i++)
			A[i] = A[i] * A[i];
		Arrays.sort(A);
	
		for(int i=n-1; i>=2; i--)
		{
			int left =  0;
			int right = i-1;
			
			while(left < right)
			{
				int sum = A[left] + A[right];
				if(sum == A[i])
					return true;
				else if(sum > A[i])
					right--;
				else
					left++;
			}
		}
		return false;
	}
}