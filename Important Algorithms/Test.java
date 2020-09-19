import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Test
{
    public static void main(String args[] ) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      while(t-->0)
      {
          String str[] = br.readLine().split(" ");
          int n = Integer.parseInt(str[0]);
          int a = Integer.parseInt(str[1]);
          int b = Integer.parseInt(str[2]);
          int c = Integer.parseInt(str[3]);

          solve(n,a,b,c);
      }
}

static void solve(int n, int a, int b, int c)
    {
        int count = 0;
       for(int i=1; i<Math.sqrt(n); i++)
         {
             if(n % i==0)
             {
                    if(n / i==i)
                    {
                        if(i == a || i == b || i ==c)
                            count++;
                    }
                    else
                    {
                            if(i == a || i == b || i ==c)
                            count++;
                            if(n/i == a || n/i == b || n/i ==c)
                            count++;
                    }
             }
         } 

         System.out.println(count);
    }

}
