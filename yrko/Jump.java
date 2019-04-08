import java.util.Scanner;

public class Jump {
	static int num = 0, n, matrix[][];
	static long  dp[][];
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		visited = new boolean[n][n];
		dp = new long[n][n];
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = s.nextInt();				
			}
		}
		
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == n-1 && j == n-1) {
					break;
				}
				if(dp[i][j] == 0)
				{
					continue;
				}
				int weight = matrix[i][j];
				
				if(i+weight < n)
				{
					dp[i+weight][j] += dp[i][j];
				}
				if(j+weight < n) 
				{
					dp[i][j+weight] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n-1][n-1]);
		s.close();
	}
}
