//this algorithm is used to validate the credit card numbers
//here is the link for this algorithm
//https://www.geeksforgeeks.org/luhn-algorithm/
package com.pnstech;
import java.util.*;
import static java.lang.System.*;
public class LuhnAlgo {

	public static void main(String[] args)
	{
				
		Scanner sc = new Scanner(in);
		String cards = sc.next();
		sc.close();
		boolean validate = isValid(cards);
		if(validate)
		out.println("Valid");
		else
			out.println("Invalid");
	}
	
	static boolean isValid(String cards)
	{
		int d;
		int sum = 0;
		boolean isSecond = false;
		
		for(int i=(cards.length()-1); i>=0; i--)
		{
			d = cards.charAt(i) - '0';
			
			if(isSecond)
				d = d*2;
			
			sum = sum + d/10;
			sum = sum + d%10;
			
			isSecond = !isSecond;
		}
		
		return (sum%10 == 0);
	}
		
}
	

