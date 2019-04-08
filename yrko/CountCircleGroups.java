import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountCircleGroups {
	static int n, aa[][];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			n = s.nextInt();
			visit = new boolean[n];
			aa = new int[n][3];
			for (int j = 0; j < n; j++) {
				int x = s.nextInt();
				int y = s.nextInt();
				int r = s.nextInt();
				aa[j][0] = x;
				aa[j][1] = y;
				aa[j][2] = r;	
			}
			for (int j = 0; j < n; j++) {
				if(!visit[j]) {
					visit[j] = true;
					qx.add(aa[j][0]);
					qy.add(aa[j][1]);
					qw.add(aa[j][2]);
					bfs();
					num++;
				}	
			}
			System.out.println(num);
			num = 0;
		}

		s.close();
	}
	static boolean[]visit;
	static int num = 0;
	static Queue<Integer> qx = new LinkedList<>();
	static Queue<Integer> qy = new LinkedList<>();
	static Queue<Integer> qw = new LinkedList<>();
	static void bfs()
	{
		int a = qx.poll();
		int b = qy.poll();
		int w = qw.poll();
		for (int i = 0; i < n; i++) {
			if(!visit[i]) {
				if(Math.sqrt(Math.pow(a-aa[i][0],2) + Math.pow(b-aa[i][1],2)) <= w + aa[i][2])
				{
					visit[i] = true;
					qx.add(aa[i][0]);
					qy.add(aa[i][1]);
					qw.add(aa[i][2]);
				}
			}
		}

		while(!qx.isEmpty()) {
			a = qx.poll();
			b = qy.poll();
			w = qw.poll();
			for (int i = 0; i < n; i++) {
				if(!visit[i]) {
					if(Math.sqrt((a-aa[i][0])^2 + (b-aa[i][1])^2) <= w+aa[i][2])
					{
						visit[i] = true;
						qx.add(aa[i][0]);
						qy.add(aa[i][1]);
						qw.add(aa[i][2]);
					}
				}
			}
		}
	}
}
