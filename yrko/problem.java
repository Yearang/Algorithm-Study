import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<ArrayList<Integer>> ad = new <ArrayList<Integer>>ArrayList();
        for (int i = 0; i < n+1; i++) {
            ad.add(new <Integer>ArrayList());
        }
        int indegree[] = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            ad.get(a).add(b);
            indegree[b]++;
        }

        while (true) {
            int t = -1;
            for (int i = 1; i < n + 1; i++) {
                if (indegree[i] == 0) {
                    t = i;
                    indegree[i]--;
                    break;
                }
            }
            if (t == -1) {
                break;
            }
            System.out.print(t + " ");
            for (int i : ad.get(t)) {
                indegree[i]--;
            }
        }
    }
}
