// mafia29 
import java.io.*;
import java.util.*;
public class GridPathsI
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
    char[][] a = new char[n][n];
    for(int i=0;i<n;i++)
    {
      String s = next();
      for(int j=0;j<n;j++)
      a[i][j] = s.charAt(j);
    }
    long[][] dp = new long[n+1][n+1];
    if(a[n-1][n-1]!='*')
    dp[n-1][n-1] = 1;
    long mod = (long)(1e9+7);
    for(int i=n-1;i>=0;i--)
    {
      for(int j=n-1;j>=0;j--)
      {
        if(i==(n-1)&&j==(n-1))
        continue;
        if(a[i][j]!='*')
        {
          long ans1 = dp[i+1][j]%mod;
          long ans2 = dp[i][j+1]%mod;
          dp[i][j] = (ans1+ans2)%mod;
        }
      }
    }
    System.out.println(dp[0][0]);
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