import java.util.Scanner;

public class a {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] a = new int [n][3];
		int[][] answer = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = s.nextInt();
			}
		}

		for (int i = 0; i < 3; i++) {
			answer[0][i] = a[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if(j == 0) 
				{
					answer[i][j] = a[i][j] + min(answer[i-1][1],answer[i-1][2]);
				}
				else if(j == 1)
				{
					answer[i][j] = a[i][j] + min(answer[i-1][0],answer[i-1][2]);
				}
				else answer[i][j] = a[i][j] + min(answer[i-1][1],answer[i-1][0]);
			}
		}
		int minimum = answer[n-1][0];
		for (int i = 1; i < 3; i++) {
			if(answer[n-1][i] < minimum)
				minimum = answer[n-1][i];
		}
		System.out.println(minimum);
	}
	static int min(int a, int b) {
		if(a>b)
		{
			return b;
		}
		else return a;
	}
}