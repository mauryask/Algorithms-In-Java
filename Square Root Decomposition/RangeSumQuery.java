/*
* T(n): O(n + sqrt(n))
* S(n): O(sqrt(n))
*/
import java.util.*;
import static java.lang.System.*;

public class RangeSumQuery 
{	 
 int[] nums;
    int blockSize;
	int[] blocks;
	
    RangeSumQuery(int[] nums)
	{	    		
		this.nums = nums;
		int n = nums.length;
		blockSize = (int)Math.sqrt(n);
		// If number of blocks perfectly divisible by blockSize then the number of blocks should be n / blockSize
		// Else if nbumber of blocks should be (n / blockSize + 1) => +1 to accomodate the rest of the elements that 
		// will not come in the compete chunk of sqrt(n) size
		
		// Another work around here is use blow 
		// numBlocks = (n + blockSize - 1) / blockSize => this does the same thing as below
		int numBlocks = (n % blockSize == 0) ? (n / blockSize) : (n / blockSize + 1);
		blocks = new int[numBlocks];
	}	
     
	//Precomputing the sum for each sqrt(n) size block 
	private void compute(int[] nums)
	{
		for(int i=0; i<nums.length; i++)
		  blocks[i/blockSize] += nums[i];		
	}	

    private int getSum(int nums[], int left, int right)
	{
		int sum = 0;
		
        while(left <= right)
		{
			/*
			* left % blockSize == 0 : Indicates that it is the starting of some block
			* left + blockSize - 1 <= right: Indicates that the block is within the range of 'right'
 			*/
			if(left % blockSize == 0 && left + blockSize - 1 <= right)
			{
				sum += blocks[left / blockSize]; // Add the precomputed answer
				left += blockSize; //Move to next bock dircetly
			}
			else //Handling partially overlaping bocks
			{
				sum += nums[left];
				left++;
			}
		}

		return sum;		
	}

	public static void main(String [] args)
	{
		int nums[] = {10,2,5,8,9,6,3,5,7,8,9,5,4,1,2,5,6};		
		RangeSumQuery rq = new RangeSumQuery(nums);
		rq.compute(nums);
		out.println(rq.getSum(nums, 5, 14));		
	}
}



