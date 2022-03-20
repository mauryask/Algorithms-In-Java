/*
* T(n) : O(n)
* S(n) : O(1)
************
https://www.geeksforgeeks.org/run-length-encoding/
*/
import static java.lang.System.*;
import java.util.*;

public class RunLengthEncoding
{
	static String encode(String str, int n)
	{
		 
		if(str == "")
			return "";
		
		String rslt = "";
		
		int i = 0;
		int j = 0;
		int count = 0;
		
		while(j<n)
		{
			if(str.charAt(i) == str.charAt(j))
			{
				count++;
				j++;
			}
			else
			{
				rslt += str.charAt(i)+ "" + count;
				count = 0;
				i = j;
			}
		}
		
		rslt += str.charAt(i) + "" + count;
		
		return rslt;
	}
	
	public static void main(String [] args)
	{
		String str = "wwwwaaadexxxxxx";
		int n = str.length();
		
		out.println(encode(str, n));
	}
}