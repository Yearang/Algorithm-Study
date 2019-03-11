import java.util.*;

public class game {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] time = new int[n + 1];
        int[] answer = new int[n + 1];
        int[] indegree = new int[n + 1];
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < n + 1; i++) {
            int t = s.nextInt();
            time[i] = t;
            int b;
            while (true) {
                b = s.nextInt();
                if (b == -1) {
                    break;
                }
                list.get(b).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);

            }
            answer[i] = time[i];
        }

        while (!q.isEmpty()) {
            int a = q.poll();
//            answer[a] = time[a];
//            if(answer[])
//            if (answer[a] == 0) {
//                answer[a] = time[a];
//            }
            for (Integer i : list.get(a)) {
                indegree[i]--;
//                time[i] += time[a];
//                if (answer[i] != 0) {
                    if (answer[i] < answer[a] + time[i]) {
                        answer[i] = answer[a] + time[i];
                    }
//                } else{
//                    answer[i] = answer[a] + time[i];
//                }


//                if(answer[i] < answer[a] + time[i])
//                    answer[i] = answer[a] + time[i];
//                if (time[i] < answer[i]) {
//                    answer[i] = time[i];
//                }
                if (indegree[i] == 0) {
                    q.offer(i);
//                    if(time[a] > time[i])
//                    if(answer[i])

                }

            }
//            for (Integer i : list.get(a)) {
//                if (answer[i] < answer[a] + time[i]) {
//                    answer[i] = answer[a] + time[i];
//                }
//            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.println(answer[i]);
        }
    }
}
//4
//        2 2 -1
//        10 -1
//        3 2 -1
//        1 1 3 -1