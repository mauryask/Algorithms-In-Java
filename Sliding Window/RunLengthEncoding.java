/*
* T(n) : O(n)
* S(n) : O(1)
************
https://www.geeksforgeeks.org/run-length-encoding/
*/
import static java.lang.System.*;

public class RunLengthEncoding
{
    static String encode(String s) {
        int n = s.length();
        
        if(n == 0) return "";
        if(n == 1) return s + "" + 1;
        
        StringBuilder sb  = new StringBuilder();
        int count = 1;
        
        for(int i=1; i<n; i++){
            if(s.charAt(i-1) == s.charAt(i))
              count++;
            else{
              sb.append(s.charAt(i-1)).append(count);
              count = 1;
            }  
        }
        
        sb.append(s.charAt(n-1)).append(count);
        
        return sb.toString();
    }
	
	public static void main(String [] args)
	{
		String str = "wwwwaaadexxxxxx";		
		out.println(encode(str));
	}
}