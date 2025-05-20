import static java.lang.System.*;
import java.util.*;

public class GeneratingAllPermutationsInArray 
{
	// Appraoch-01: With extra space
	static void printAllPermutations(int[] A, boolean map[], Stack<Integer> stack)
	{
		if(stack.size() == A.length)
		{
			out.println(stack);
			return;
		}
		
		for(int i=0; i<A.length; i++)
		{
			if(!map[i])
			{
				map[i] = true;
				stack.push(A[i]);
				printAllPermutations(A, map, stack);
				map[i] = false;
				stack.pop();
			}
		}
	}
	
	// Approach-02: In case of strings
	static void printAllPermutations2(String input, String output)
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
			printAllPermutations2(newInput, newOutput);
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
	
	//Approach-03: Without extra space
	static void printAllPermutations3(int[] A, int index){
		if(index == A.length){
			for(int x : A){
				out.print(x);
			}
			out.println();
			return;
		}
		
		for(int i=index; i<A.length; i++){
			swap(A, i, index);
			printAllPermutations3(A, index+1);
			swap(A, i, index);
		}
	}
	
	static void swap(int[] A, int i, int index){
		int temp = A[index];
		A[index] = A[i];
		A[i] = temp;
	}
	
	public static void main(String [] args)
	{
		int A[] = {1,2,3};
		boolean[] map = new boolean[A.length];
		Stack<Integer> stack = new Stack<>();
		printAllPermutations(A, map, stack);		
		// printAllPermutations3(A, 0);		
		// String input = "RGB";
	    // printAllPermutations2(input, "");
	}
}
