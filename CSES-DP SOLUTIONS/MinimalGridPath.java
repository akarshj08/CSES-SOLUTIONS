// mafia29 
import java.io.*;
import java.util.*;
public class MinimalGridPath
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
    StringBuilder ans = new StringBuilder();
    Queue<int[]> q = new LinkedList<>();
    boolean[][] dp = new boolean[n][n];
    dp[0][0] = true;
    q.add(new int[] {0,0});
    ans.append(a[0][0]);
    if(n==1)
    {
      System.out.println(ans.toString());
      return;
    }
    while(!q.isEmpty())
    {
      int size = q.size();
      char min = 'Z';
      List<int[]> ls = new ArrayList<>();
      for(int i=0;i<size;i++)
      {
        int[] curr = q.poll();
        //System.out.print(curr[0]+" "+curr[1]+"     ");
        int x = curr[0], y = curr[1];
        if((x+1)<n)
        min = (char)(Math.min(min,a[x+1][y]));
        if((y+1)<n)
        min = (char)(Math.min(min,a[x][y+1]));
        ls.add(new int[] {x,y});
      }
      //System.out.println(min+" "+q);
      for(int[] b : ls)
      {
        int x = b[0], y = b[1];
        if((x+1)<n&&a[x+1][y]==min&&!dp[x+1][y])
        {
          dp[x+1][y] = true;
          //System.out.println((x+1)+" "+y+"  "+a[x+1][y]+" "+min);
          q.add(new int[] {x+1,y});
        }
        if((y+1)<n&&a[x][y+1]==min&&!dp[x][y+1])
        {
          //System.out.print("   "+x+" "+(y+1));
          dp[x][y+1] = true;
          q.add(new int[] {x,y+1});
        }
        //System.out.println();
      }
      ans.append(min);
      if(!q.isEmpty()&&q.peek()[0]==(n-1)&&q.peek()[1]==(n-1))
      break;
    }
    System.out.println(ans.toString());
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