// Question Number  : #19

import static java.lang.System.*;
public class LargestAreaUnderHistogram
{
	public static void main(String [] args)
	{
       int A[] = {2,0,2};
       out.println(largestRectangleArea(A));	   
	}
	
	// Time Complexity  : O(n)
	// Space Complexity : O(n)
	static int largestRectangleArea(int A[])
	{
		int n = A.length;
		int max_area = 0;
		
		// write your code here 
		
		return max_area;
	}
	
	// Time Complexity  : O(n^2)
	// Space Complexity : O(1)
	
	static int largestRectangleArea2(int A[])
	{
	  int n = A.length;
      int max_area = 0;
      int width = 0;
	  
      for(int i=0;i<n; i++)
	  {
		  width = 1;
		  
		  // move to the right
		  for(int j=i+1; j<n; j++)
		  {
			  if(A[j] >= A[i])
				  width++;
			  else
				  break;
		  }
		  
		  // move to the left
		  for(int j=i-1; j>=0; j--)
		  {
			  if(A[j] >= A[i])
				  width++;
			  else
				  break;
		  }
		  
		  max_area = Math.max(max_area, A[i] * width); 
	  }		  
	  return max_area;
	}
}