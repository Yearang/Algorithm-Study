import java.util.Scanner;

public class One {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] dp = new int[100001];
		
		dp[1] = 0;
		if(n == 1)
		{
			System.out.println(dp[1]);
			return;
		}

		for (int i = 2; i <= n; i++) 
		{
			dp[i] = dp[i-1] + 1;
			if(i%3 == 0)
			{
				dp[i] = min(dp[i/3] + 1,dp[i]);
			}
			else if(i%2 == 0)
			{
				dp[i] = min(dp[i/2] + 1,dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
	static int min(int a, int b)
	{
		if(a>b)
		{
			return b;
		}
		else return a;
	}
}
