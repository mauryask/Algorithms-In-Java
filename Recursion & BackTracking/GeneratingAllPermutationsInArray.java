import static java.lang.System.*;
import java.util.*;

public class GeneratingAllPermutationsInArray 
{
	// Appraoch that uses extra space
	static void solve(int[] nums, boolean map[], List<Integer> ds)
	{
		if(ds.size() == nums.length)
		{
			out.println(ds);
			return;
		}
		
		for(int i=0; i<nums.length; i++)
		{
			if(!map[i])
			{
				map[i] = true;
				ds.add(nums[i]);
				solve(nums, map, ds);
				map[i] = false;
				ds.remove(ds.size()-1);
			}
		}
	}
	
	public static void main(String [] args)
	{
		int nums[] = {1,2,3,4};
		boolean[] map = new boolean[nums.length];
		List<Integer> ds = new ArrayList<>();
		solve(nums, map, ds);
	}
}
