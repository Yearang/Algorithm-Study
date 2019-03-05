import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
    static int [][] graph;
    static boolean[] visited;
    static int n;
    static int e;
    static int start = 1;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        e = s.nextInt();
        visited = new boolean[n + 1];
        graph = new int[n+1][n+1];
        for (int i = 0; i < e; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        bfs(1);
        System.out.println(cnt);


    }

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visited[i] = true;
//        System.out.print(i + " ");

        int temp;
        while (!q.isEmpty()) {
            temp = q.poll();
            for (int j = 0; j < n + 1; j++) {
                if (graph[temp][j] == 1 && visited[j] == false) {
                    q.offer(j);
                    visited[j] = true;
//                    System.out.print(j + " ");
                    cnt++;
                }
            }

        }
    }

}

