// mafia29 
import java.io.*;
import java.util.*;
public class CountingTilings
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
    long mod = (long)(1e9+7);
    int maxmask = (1<<n);
    long[][] dp = new long[m][maxmask+1];
    for(int i=0;i<m;i++)
    {
      for(int j=0;j<=maxmask;j++)
      dp[i][j] = -1;
    }
    long ans = findans(n,m,0,0,mod,dp);
    System.out.println(ans);
  }
  public static long findans(int n,int m,int ind,int mask,long mod,long[][] dp)
  {
    if(ind>=m)
    {
      if(mask==0)
      return 1;
      return 0;
    }
    if(dp[ind][mask]!=-1)
    return dp[ind][mask];
    long ans = 0;
    List<Integer> nextmask = new ArrayList<>();
    findnextmask(mask,0,0,n,nextmask);
    for(int newmask : nextmask)
    ans = (ans+findans(n,m,ind+1,newmask,mod,dp))%mod;
    return dp[ind][mask] = ans;
  }
  public static void findnextmask(int mask,int ind,int nextmask,int n,List<Integer> ls)
  {
    if(ind>=n)
    {
      ls.add(nextmask);
      return;
    }
    int curr = (mask&(1<<ind));
    if(curr!=0)
    findnextmask(mask,ind+1,nextmask,n,ls);
    if(ind!=(n-1))
    {
      int next = (mask&(1<<(ind+1)));
      if(curr==0&&next==0)
      findnextmask(mask,ind+2,nextmask,n,ls);
    }
    if(curr==0)
    findnextmask(mask,ind+1,(nextmask+(1<<ind)),n,ls);
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