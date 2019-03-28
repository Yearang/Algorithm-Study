import java.util.Scanner;

public class Wine {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n =  s.nextInt();
		int [] m = new int[n];
		for (int i = 0; i < n; i++) 
		{
			m[i] = s.nextInt();
		}
		int[] dp = new int[n];
		dp[0] = m[0];
		if(n == 1)
		{
			System.out.println(dp[0]);
			return;
		}
		dp[1] = m[0] + m[1];
		if(n <= 2) {
			System.out.println(dp[1]);
			return;
		}
		else {
			dp[2] = max(m[0]+m[2], m[1]+m[2], dp[1]);

			int max1 = max(dp[0],dp[1],dp[2]);
			for (int i = 3; i < n; i++) 
			{
				dp[i] = max(m[i-1] + m[i] + dp[i-3], m[i] + dp[i-2], dp[i-1]);
				if(max1 < dp[i])
				{
					max1 = dp[i];
				}
			}
			System.out.println(max1);
		}
	}

	static int max(int a, int b, int c)
	{
		if(a >= b && a >= c)
		{
			return a;
		}
		else if(b >= c && b >= a)
		{
			return b;
		}else
			return c;
	}
}
