// mafia29 
import java.io.*;
import java.util.*;
public class MoneySums
{
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  static StringTokenizer st; 
  static String next() 
  { 
    while(st==null||!st.hasMoreElements()) 
    { 
      try 
      {
        st = new StringTokenizer(br.readLine()); 
      }
      catch(IOException e) 
      {
        e.printStackTrace(); 
      }
    } 
    return st.nextToken(); 
  } 
  static int nextInt() 
  { 
    return Integer.parseInt(next()); 
  } 
  static long nextLong() 
  { 
    return Long.parseLong(next()); 
  } 
  static double nextDouble() 
  { 
    return Double.parseDouble(next()); 
  }
  public static boolean[] steve(int k)//steve for prime
  {
    boolean[] prime = new boolean[k];
    Arrays.fill(prime,true);
    prime[0] = false;
    prime[1] = false;
    for(int i=2;i*i<k;i++)
    {
      if(prime[i]==true)
      {
        for(int j=i*i;j<k;j+=i)
        prime[j] = false;
      }
    }
    return prime;
  }
  public static int gcd(int a,int b)//gcd
  {
    if(b==0)
    return a;
    return gcd(b,a%b);
  }
  public static int lcm(int a,int b)//lcm
  {
    return(a/gcd(a,b))*b;
  }
  public static void main(String[] args) 
  {
    int n = nextInt();
    int[] a = new int[n];
    int totsum = 0;
    for(int i=0;i<n;i++)
    {
      a[i] = nextInt();
      totsum += a[i];
    }
    boolean[] dp = new boolean[totsum+1];
    dp[0] = true;
    for(int ind=0;ind<n;ind++)
    {
      boolean[] temp = new boolean[totsum+1];
      for(int sum=0;sum<=totsum;sum++)
      {
        if(dp[sum])
        {
          temp[sum+a[ind]] = true;
          temp[sum] = true;
        }
      }
      dp = temp;
    }
    List<Integer> ans = new ArrayList<>();
    for(int i=1;i<=totsum;i++)
    {
      if(dp[i])
      ans.add(i);
    }
    System.out.println(ans.size());
    for(int val : ans)
    System.out.print(val+" ");
  }
  public static boolean checkprime(int N)//checkprime
  {
    int i;
    if(N==1)
    return false;
    if((N&1)==0&&N!=2)
    return false;
    else if(N%3==0&&N!=3)
    return false;
    else if(N%11==0&&N!=11)
    return false;
    else if(N%13==0&&N!=13)
    return false;
    else if(N%17==0&&N!=17)
    return false;
    else
    {
      for(i=3;i<=Math.sqrt(N);i+=2)
      {
        if(N%i==0)
        return false;
      }
    }
    return true;
  }
}