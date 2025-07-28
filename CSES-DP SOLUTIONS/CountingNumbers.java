// mafia29 
import java.io.*;
import java.util.*;
public class CountingNumbers
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
    long a = nextLong();
    long b = nextLong();
    long ans = findans(b)-findans(a-1);
    System.out.println(ans);
  }
  public static long findans(long a)
  {
    String s = Long.toString(a);
    int n = s.length();
    long[][][] dp = new long[n][11][2];
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<=10;j++)
      dp[i][j][0] = dp[i][j][1] = -1;
    }
    return solve(s,0,n,-1,true,true,dp);
  }
  public static long solve(String s,int ind,int n,int prev,boolean tight,boolean zero,long[][][] dp)
  {
    if(ind>=n)
    return 1;
    int tigind = 0;
    if(tight)
    tigind = 1;
    if(dp[ind][prev+1][tigind]!=-1&&!zero)
    return dp[ind][prev+1][tigind];
    long ans = 0;
    int max = 9;
    if(tight)
    max = s.charAt(ind)-'0';
    for(int i=0;i<=max;i++)
    {
      if(!zero&&(i==prev))
      continue;
      ans += solve(s,ind+1,n,i,tight&&(i==max),zero&&(i==0),dp);
    }
    if(!zero)
    dp[ind][prev+1][tigind] = ans;
    return ans;
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