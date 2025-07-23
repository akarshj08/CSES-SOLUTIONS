// mafia29 
import java.io.*;
import java.util.*;
public class ArrayDescription
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
    int m = nextInt();
    int[] a = new int[n];
    for(int i=0;i<n;i++)
    a[i] = nextInt();
    long mod = (long)(1e9+7), ans = 0;
    long[][] dp = new long[n+1][m+2];
    for(int i=1;i<=m;i++)
    {
      if(a[0]==0||a[0]==i)
      dp[1][i] = 1;
    }
    for(int i=2;i<=n;i++)
    {
      for(int x=1;x<=m;x++)
      {
        if(a[i-1]==0||a[i-1]==x)
        dp[i][x] = (dp[i-1][x-1]+dp[i-1][x]+dp[i-1][x+1])%mod;
      }
    }
    for(int i=1;i<=m;i++)
    ans = (ans+dp[n][i])%mod;
    System.out.println(ans);
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