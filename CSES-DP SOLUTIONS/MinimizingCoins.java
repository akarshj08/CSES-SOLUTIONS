// mafia29 
import java.io.*;
import java.util.*;
public class MinimizingCoins
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
    int tar = nextInt();
    int[] a = new int[n];
    for(int i=0;i<n;i++)
    a[i] = nextInt();
    int[][] dp = new int[n+1][tar+1];
    for(int i=0;i<=n;i++)
    {
      for(int j=1;j<=tar;j++)
      dp[i][j] = 100000000;
    }
    for(int i=n-1;i>=0;i--)
    {
      for(int j=1;j<=tar;j++)
      {
        int ans1 = 100000000;
        if(j>=a[i])
        ans1 = 1+dp[i][j-a[i]];
        int ans2 = dp[i+1][j];
        dp[i][j] = Math.min(ans1,ans2);
      }
    }
    if(dp[0][tar]>=100000000)
    System.out.println(-1);
    else
    System.out.println(dp[0][tar]);
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