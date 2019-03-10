import java.util.Scanner;

public class cycle {
    static int[][] matrix;
    static boolean[] visited;
    static int start, count, n;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
//        int[][] m = new int[t][10000];
        int a = 0;

        while (t > a) {
            n = s.nextInt();
            matrix = new int[n+1][n+1];
            visited = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                int c = s.nextInt();
                matrix[i][c] = 1;
                matrix[c][i] = 1;
            }
            for (int i = 1; i <= n; i++) {
                start = i;
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }

            }
            System.out.println(count);
            count = 0;
            a++;
        }
    }

    public static void dfs(int i) {
        visited[i] = true;
//        if (i == start) {
//            count++;
//            return;
//        }
        for (int j = 1; j <= n; j++) {
            if (!visited[j] && matrix[i][j] == 1) {
                visited[j] = true;
                dfs(j);
            }
        }
    }
}
