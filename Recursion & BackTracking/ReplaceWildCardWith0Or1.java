// https://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/
import static java.lang.System.*;
import java.util.*;

public class ReplaceWildCardWith0Or1
{	
   static void solve(StringBuilder sb, int start, int end, int count)
   {	   
	    if(count == 0)
	    {
		   out.println(sb);
		   return;
	    }
	   
		 for(int j=0; j<=1; j++)
		 { 
			for(int i=start; i<=end; i++)
			{
				if(sb.charAt(i) == '?')
				{
					sb.replace(i, i+1, j+"");
					solve(sb, i+1, end, count-1);
					sb.replace(i, i+1, "?");	
				}						
			}
		 }
   }
   
   //Same as above 
   // Making string of length 3 with two charcaters 'ab'
    
	static void printStringOfLengthX(String input, String output, int start, int count, int wordLength)
	{
		if(count  == 0)
		{
			out.println(output);
			return;
		}
		
		for(int i=0; i<input.length(); i++)
		{
			for(int j=start; j<wordLength; j++)
			{
				printPermutations(input, output + input.charAt(i), j+1, count - 1, wordLength);
			}
		}
	}

   public static void main(String [] args)
   {
	   String str = "1??0?101";
	   StringBuilder sb = new StringBuilder(str);
	   int count = 0;
	   
	   for(int i=0; i<str.length(); i++)
		   if(str.charAt(i) == '?')
			   count++;
	   
	   solve(sb, 0, str.length()-1, count);
   }
}