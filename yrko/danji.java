import java.util.*;

public class danji {
    static boolean[][] visited;
    static int n;
    static int[][] m;
    static int cnt;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = new int[n][n];
        visited = new boolean[n][n];
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            temp[i] = s.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(temp[i].substring(j, j + 1));
            }
        }
        int total = 0;
        int[] count = new int[10000];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j);
                if(cnt != 0) {
//                    System.out.println(cnt);
                    count[total] = cnt;
                    total++;

                }
                cnt = 0;
                if (m[i][j] == 1 && visited[i][j] == false) {
                    bfs(i, j);
                }
            }

        }
        System.out.println(total);
        int[] sc = new int[total];
        for (int i = 0; i < total; i++) {
            sc[i] = count[i];
        }
        Arrays.sort(sc);
        for (int i = 0; i < total; i++) {
            System.out.println(sc[i]);
        }
    }
    public static void bfs(int i, int j) {
        Queue<Integer> q = new LinkedList<Integer>();
//        q.offer()
    }

    public static void dfs(int i, int j) {
        if (visited[i][j] == false && m[i][j] == 1) {
            visited[i][j] = true;
//            System.out.println(i + " " + j);
            cnt++;
        } else {
            return;
        }

        for (int k = j; k < n; k++) {
            if (m[i][k] == 0) {
                break;
            }
            if (m[i][k] == 1 && visited[i][k] == false) {
                dfs(i, k);
            }
        }

        for (int k = i; k < n; k++) {
            if (m[k][j] == 0) {
                break;
            }
            if (m[k][j] == 1 && visited[k][j] == false) {
                dfs(k, j);
            }
        }
        for (int k = j; k >= 0; k--) {
            if (m[i][k] == 0) {
                break;
            }
            if (m[i][k] == 1 && visited[i][k] == false) {
                dfs(i, k);
            }
        }
        for (int k = i; k >= 0; k--) {
            if (m[k][j] == 0) {
                break;
            }
            if (m[k][j] == 1 && visited[k][j] == false) {
                dfs(k, j);
            }
        }

    }
}
