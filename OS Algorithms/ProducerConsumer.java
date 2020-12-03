import static java.lang.System.*;
import java.util.*;

public class ProducerConsumer
{
	static int buffer_size  = 4;
    static int mutex = 1;
	static int empty = buffer_size;
	static int full = 0;
	static int x = 0;
	
	static void producer()
	{
		mutex = wait(mutex);
		empty = wait(empty);
		full = signal(full);
		x++;
		out.println("The producer prodeces: "+x);
		mutex = signal(mutex);
	}
	
	static void consumer()
	{
		mutex = wait(mutex);
		empty = signal(empty);
		full = wait(full);
		out.println("The consumer consumes: "+x);
		x--;
		mutex = signal(mutex);
	}
	
	static int wait(int s)
	{
		return --s;
	}
	
	static int signal(int s)
	{
		return ++s;
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			out.print("Enter your choice: ");
		    int n = sc.nextInt();
			switch(n)
			{
				case 1:
				 if(mutex == 1 && full != buffer_size)
					 producer();
				 else
					 out.println("Buffer is full..");
				break;
				
				case 2: 
				if(mutex == 1 && full != 0)
					consumer();
				else
					out.println("Buffer is empty..");
				break;
				
				case 3: 
				exit(0);
				
				default :
				out.println("Invalid input..");
				break;
			}
		}
	}
}