// mafia29 
import java.io.*;
import java.util.*;
public class Projects
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
    int[][] a = new int[n][3];
    for(int i=0;i<n;i++)
    {
      a[i][0] = nextInt();
      a[i][1] = nextInt();
      a[i][2] = nextInt();
    }
    Arrays.sort(a,(x,y)-> Integer.compare(x[1],y[1]));
    long[] dp = new long[n];
    for(int ind=0;ind<n;ind++)
    {
      long ans1 = 0, ans2 = a[ind][2];
      if((ind-1)>=0)
      ans1 = dp[ind-1];
      int nextind = findindex(a,n,a[ind][0],ind);
      if(nextind!=-1)
      ans2 += dp[nextind]; 
      dp[ind] = Math.max(ans1,ans2);
    }
    System.out.println(dp[n-1]);
  }
  public static int findindex(int[][] a,int n,int val,int ind)
  {
    int l = 0, r = ind-1, ans = -1;
    while(l<=r)
    {
      int mid = ((r-l)/2)+l;
      if(a[mid][1]<val)
      {
        ans = mid;
        l = mid+1;
      }
      else
      r = mid-1;
    }
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

}