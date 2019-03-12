import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class miro {
    static int n, m, miro[][];
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        miro = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String a = s.next();
            for (int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(a.substring(j, j + 1));
            }
        }
        visit[0][0] = true;
//        dfs(0, 0);
        q1.offer(0);
        q2.offer(0);
        bfs();
        System.out.println(count);

    }

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer>q2 =new LinkedList<>();
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    static int x[] = {1, 0, -1, 0};
    static int y[] = {0, 1, 0, -1};
    static int a, b, c, d, count;

    public static void dfs(int k, int l) {
        if (k == n - 1 && l == m - 1) {
            return;
        }
        a = k;
        b = l;

        for (int i = 0; i < 4; i++) {
            if (c == n - 1 && d == m - 1) {
                return;
            }
            c = a + x[i];
            d = b + y[i];
            if (c >= 0 && d >= 0 && c < n && d < m) {
                if (miro[c][d] == 1 && visit[c][d] == false) {
//                    s1.push(c);
//                    s2.push(d);
                    q1.offer(c);
                    q2.offer(d);

                    System.out.println(c + " " + d);
                    visit[c][d] = true;
                    count++;
                    dfs(c, d);

                }
            }
        }
    }

    public static void bfs() {
        while (!q1.isEmpty() && !q2.isEmpty()) {
            a = q1.poll();
            b = q2.poll();
            visit[a][b] = true;
//            System.out.println(a + " "+ b);
            count = miro[a][b];
            if (a == n - 1 && b == m - 1) {
                return;
            }
//            miro[a][b] += ;

            for (int i = 0; i < 4; i++) {
                c = a + x[i];
                d = b + y[i];
                if (c >= 0 && d >= 0 && c < n && d < m) {
                    if (miro[c][d] == 1 && visit[c][d] == false) {
                        miro[c][d] += miro[a][b];
                        q1.offer(c);
                        q2.offer(d);
                    }
                }
            }
        }

    }
}
