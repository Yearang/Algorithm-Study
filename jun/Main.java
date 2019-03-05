import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static boolean []visit = new boolean[100001];
    static int []line = new int[100001];
    static int BFS(int a, int target)
    {
        Queue<Integer> q = new LinkedList<Integer>();

        int []move = new int[3];
        int b = 0;

        visit[a] = true;
        line[a] =1;
        q.add(a);

        while (!q.isEmpty())
        {


            a=q.poll();
            move[0]= a+1;
            move[1]= a-1;
            move[2]= a*2;

            for (int i = 0; i <3 ; i++)
            {
                b=move[i];
                if (b>=0 && b<=100000 && visit[b]== false)
                {

                    q.add(b);
                    visit[b]= true;
                    line[b] = line[a]+1;
                    if (target == b) {
                        return line[b]-1;
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int young;
        int old;
        st = new StringTokenizer(bf.readLine());
        old = Integer.parseInt(st.nextToken());
        young = Integer.parseInt(st.nextToken());
        System.out.println(BFS(old,young));





    }
}