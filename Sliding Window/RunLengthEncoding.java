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
		String s = "";
		
		int i = 0;
		while(i<n)
		{
			char ch = str.charAt(i);
			int count = 0;
			while(i < n && str.charAt(i) == ch)
			{
				count++;
				i++;
			}
			
			s += ch+""+ count;
		}
		
		return s;
	}
	
	public static void main(String [] args)
	{
		String str = "wwwwaaadexxxxxx";
		int n = str.length();
		
		out.println(encode(str, n));
	}
}