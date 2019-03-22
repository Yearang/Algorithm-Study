import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = s.nextInt();
        }
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - coin[i] >= 0) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }
        System.out.println(dp[k]);

    }
}
