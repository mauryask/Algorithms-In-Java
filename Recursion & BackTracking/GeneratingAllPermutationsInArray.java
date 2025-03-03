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
	
	// Generating permutations in case of strings
	// Anorther approach But not the best
	static void strPerms(String input, String output)
	{
		if(input.length() == 0)
		{
			out.println(output);
			return;
		}
		
		for(int i=0; i<input.length(); i++)
		{
			String newInput = subStr(input, i);
			String newOutput = output + input.charAt(i);
			strPerms(newInput, newOutput);
		}
	}
	
	static String subStr(String str, int index)
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			if(index != i)
				sb.append(ch);
		}
		
		return  sb.toString();
	}
	
	public static void main(String [] args)
	{
		/*int nums[] = {1,2,3,4};
		boolean[] map = new boolean[nums.length];
		List<Integer> ds = new ArrayList<>();
		solve(nums, map, ds);*/
		
		String input = "RGB";
	    strPerms(input, "");
	}
}
