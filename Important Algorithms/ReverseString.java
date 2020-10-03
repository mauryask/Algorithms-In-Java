import static java.lang.System.*;
public class ReverseString
{
	public static void main(String [] args)
	{
		String str = "Shubham";
		method2(str);
	}
	
	static void method1(String str)
	{
		int n = str.length();
		
		int half_length = n/2;
		
		char ch[] = str.toCharArray();
		for(int i=0;i<half_length; i++)
		{
			char temp = ch[i];
			ch[i] = ch[n-1-i];
			ch[n-1-i] = temp;
		}
		
		out.println(String.valueOf(ch));
	}
	
	static void method2(String str)
	{
		String xstr = "";
		for(int i=str.length()-1;i>=0; i--)
		{
			xstr += str.charAt(i);
		}
		out.println(xstr);
	}
}