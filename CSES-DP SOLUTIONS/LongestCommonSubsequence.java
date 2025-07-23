// mafia29 
import java.io.*;
import java.util.*;
public class LongestCommonSubsequence
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
    int[] b = new int[m];
    for(int i=0;i<n;i++)
    a[i] = nextInt();
    for(int i=0;i<m;i++)
    b[i] = nextInt();
    int[][] dp = new int[n][m];
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<m;j++)
      dp[i][j] = -1;
    }
    int len = findans(a,b,0,0,n,m,dp);
    System.out.println(len);
    int i = 0, j = 0;
    while(i<n&&j<m)
    {
      if(a[i]==b[j])
      {
        System.out.print(a[i]+" ");
        i++;
        j++;
      }
      else
      {
        if((i+1)<n&&dp[i+1][j]==dp[i][j])
        i++;
        else
        j++;
      }
    }
  }
  public static int findans(int[] a,int[] b,int ind1,int ind2,int n,int m,int[][] dp)
  {
    if(ind1>=n||ind2>=m)
    return 0;
    if(dp[ind1][ind2]!=-1)
    return dp[ind1][ind2];
    if(a[ind1]==b[ind2])
    return dp[ind1][ind2] = 1+findans(a,b,ind1+1,ind2+1,n,m,dp);
    int ans1 = findans(a,b,ind1+1,ind2,n,m,dp);
    int ans2 = findans(a,b,ind1,ind2+1,n,m,dp);
    return dp[ind1][ind2] = Math.max(ans1,ans2);
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