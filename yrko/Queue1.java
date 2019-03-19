import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] list = new int[m];
        for (int i = 0; i < m; i++) {
            list[i] = s.nextInt();
        }
        Queue q = new LinkedList();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
//        System.out.println(q.peek());

//        System.out.println(((LinkedList) q).indexOf(2));
        int b = 0;
        for (int i = 0; i < m; i++) {
//            int pop = -1;
            while (true) {
                if (q.peek().equals(list[i])) {
                    q.poll();
                    break;
                }
                int a = ((LinkedList) q).indexOf(list[i]);
                if (q.size() / 2 >= a) {
                    b += a;
                    Queue qt = new LinkedList();
                    for (int j = 0; j < q.size() - a; j++) {
                        qt.offer(((LinkedList) q).get(a + j));
                    }
                    for (int j = 0; j < a; j++) {
                        qt.offer(((LinkedList) q).get(j));
                    }
                    q.clear();
                    for (int j = 0; j < qt.size(); j++) {

                        q.offer(((LinkedList) qt).get(j));
                    }
                } else {
                    b += q.size() - a;
                    Queue qt = new LinkedList();
                    for (int j = 0; j < q.size()-a; j++) {
                        qt.offer(((LinkedList) q).get(a + j));
                    }
                    for (int j = 0; j < a; j++) {
                        qt.offer(((LinkedList) q).get(j));
                    }
                    q.clear();
                    for (int j = 0; j < qt.size(); j++) {

                        q.offer(((LinkedList) qt).get(j));
                    }
                }
            }
        }
        System.out.println(b);
    }
}
