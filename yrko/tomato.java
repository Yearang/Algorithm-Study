import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tomato {
    static boolean[][] visited;
    static int[][] box;
    static int n;
    static int m;
    static Queue<Integer> qx = new LinkedList<Integer>();
    static Queue<Integer> qy = new LinkedList<Integer>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();
        visited = new boolean[n][m];
        box = new int[n][m];
        int zero = 0;
        int one = 0;
        int minus = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = s.nextInt();
                if (box[i][j] == 1) {
                    qx.add(i);
                    qy.add(j);
                }
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (cnt == 1) {
            System.out.println(0);
            return;
        }
        System.out.println(cnt-1);

    }


    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};
    static int cnt = 1;

    private static void dfs(int i, int j) {
        box[i][j] = 1;
        cnt++;

        for (int a = 0; a < 4; a++) {
            int dx = i + x[a];
            int dy = j + y[a];

            if ((-1 < dx && dx < n) && (-1 < dy && dy < m) && box[dx][dy] == 0) {
                dfs(dx, dy);
            }
        }
    }

    static int a, b, c, d;

    public static void bfs() {
        while (!qx.isEmpty() && !qy.isEmpty()) {
            a = qx.poll();
            b = qy.poll();

            visited[a][b] = true;

            for (int k = 0; k < 4; k++) {
                c = a + x[k];
                d = b + y[k];
                if (c >= 0 && d >= 0 && c < n && d < m) {
                    if (visited[c][d] == false && box[c][d] == 0) {
                        qx.add(c);
                        qy.add(d);
                        visited[c][d] = true;
                        box[c][d] = box[a][b] + 1;
                        cnt = box[c][d];
                    }
                }
            }


        }
    }
}
