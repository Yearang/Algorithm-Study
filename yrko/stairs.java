import java.util.Scanner;

public class stairs {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = s.nextInt();
		}
		int [] dp = new int[n];
		dp[0] = list[0];
		dp[1] = max(list[0] + list[1], list[1]);
		dp[2] = max(list[0] + list[2], list[1] + list[2]);
		
		for (int i = 3; i < n ; i++) {
			dp[i] = max(list[i-1] + list[i] + dp[i-3], dp[i-2] + list[i]);
		}
		System.out.println(dp[n-1]);
	}
	
	
	static int max(int a, int b)
	{
		if(a > b)
		{
			return a;
		}
		else {
			return b;
		}
	}
}
