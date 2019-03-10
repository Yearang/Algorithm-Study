import java.util.*;

public class line {
    static int n, m, indegree[];
//    static int sutd[][];
    static boolean visit[];
    static LinkedList<Integer>[] l;
    static Queue<Integer> q = new LinkedList<Integer>();
    static ArrayList<Integer>[] con;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0; i<n+1; i++)
            list.add(new ArrayList<Integer>());
        indegree = new int[n + 1];
//        stud = new int[n+1][n+1];
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
//            stud[a][b] = 1;
//            l[]
            list.get(a).add(b);
            indegree[b]++;
        }
//        topolog();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int a = q.poll();
            System.out.print(a + " ");

            for(Integer i : list.get(a)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
//            for (int i = 1; i < n + 1; i++) {
//                if (stud[a][i] == 1) {
//                    indegree[i]--;
//                    if (indegree[i] == 0) {
//                        q.add(i);
//                    }
//                }
//            }
        }
//        return;
    }
}
