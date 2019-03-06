import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static boolean [] visit;
    static int vertex;
    static int edge;
    static int start;
    static int [][]map;
    static void dfs(int Node)
    {

        visit[Node] = true;
        System.out.print(Node+" ");
        for (int i = 1; i <= vertex ; i++) {
            if (map[Node][i] == 1 && visit[i]==false) {
                dfs(i);
            }

        }

    }
    static void bfs(int Node)
    {

        Queue <Integer>q = new LinkedList<Integer>();
        q.add(Node);
        int a ;
        visit[Node] = true;
        while (!q.isEmpty())
        {
            a= q.poll();
            System.out.print(a+" ");
            for (int i = 1; i <= vertex ; i++) {
                if (map[a][i] == 1 && visit[i] == false)
                {
                q.add(i);
                visit[i]= true;
                }

            }


        }


    }

    public static void main(String[] args) throws IOException {



        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;//스트링의 토큰을 자른다.
        st= new StringTokenizer(bf.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        map = new int[vertex+1][vertex+1];
        visit = new boolean[vertex+1];



        for (int i = 1; i <= edge ; i++) {
            st = new StringTokenizer(bf.readLine());
            int here = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            map[here][next]= 1;
            map[next][here]= 1;
        }

       dfs(start);
        System.out.println();
        visit = new boolean[vertex+1];
        bfs(start);
    }
}