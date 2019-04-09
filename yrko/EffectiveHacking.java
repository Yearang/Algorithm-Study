import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EffectiveHacking {
	static ArrayList<Integer>[] add;
	static int num = 0;
	static int[] max;
	static boolean [] visit;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        add = new ArrayList[n+1];
        max = new int[n+1];
		for (int i = 0; i <= n; i++) {
			add[i] = new ArrayList<>();
		}

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            add[a].add(b);
        }
		
		
		for (int i = 1; i < n+1; i++) {
			visit = new boolean[n+1];
			dfs(i);
		}
		int maxx = max[0];
		for (int i = 1; i < n; i++) {
			maxx = Math.max(max[i], maxx);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n; i++) {
			if(maxx == max[i])
				sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int i) {
		visit[i] = true;
		for(int c : add[i]) {
			if(visit[c]) 
			{
				continue;
			}
				max[c]++;
				dfs(c);
			}
		}
	}