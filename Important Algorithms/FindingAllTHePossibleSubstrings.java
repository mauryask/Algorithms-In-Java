import static java.lang.System.*;
import java.util.*;

public class FindingAllTHePossibleSubstrings 
{
	public static void main(String [] args)
	{  
	   String str = "LoremIpsum";
	   int n = str.length();
	   
	   for(int l=1; l<=n; l++)
	   {   out.println("-----------> Length : "+l);
		   for(int i=0; i<n-l+1; i++)
		   {
			   int j = i+l-1;
			   out.print(str.substring(i,j+1)+" ");
		   }
		   out.println();
	   }
	}
 }
