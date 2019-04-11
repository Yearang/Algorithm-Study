import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hiking1 {
	static int t, n, k, max = 0;
	//	static ArrayList<Integer> al = new ArrayList<>();
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	static int [][] matrix, num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			realmax = 0;
			matrix = new int[n][n];
			num = new int[n][n];
			max = 0;
			for (int j = 0; j <  n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < n; j2++) {
					matrix[j][j2] = Integer.parseInt(st.nextToken());
					if(max < matrix[j][j2])
					{
						max = matrix[j][j2];
					}
				}
			}

			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(matrix[j][j2] == max)
					{
						qx.add(j);
						qy.add(j2);				
					}
				}
			}
			//			System.out.println(max);
			while(!qx.isEmpty()) 
			{
				max = 0;
				visit = new boolean[n][n];
				num = new int[n][n];
				int x = qx.poll();
				int y = qy.poll();
				//				qx1 = new LinkedList<Integer>();
				//				qy1 = new LinkedList<Integer>();
				//				qx1.add(x);
				//				qy1.add(y);
				//				bfs();
				num[x][y] = 1;
				dfs(x,y);
				if(max > realmax) {
					realmax = max;
				}
			}
			int temp = i+1;
			System.out.println("#" +temp + " " + realmax);
			realmax = 0;
		}		

	}
	static int realmax = 0;
	static Queue<Integer> qx1 = new LinkedList<Integer>();
	static Queue<Integer> qy1 = new LinkedList<Integer>();
	static int [] xx = {1,-1,0,0};
	static int [] yy = {0,0,1,-1};
	static boolean [][] visit;


	static void dfs(int a, int b) 
	{
		visit[a][b] = true;

		for (int i = 0; i < 4; i++) {
			int x1 = a + xx[i];
			int y1 = b + yy[i];
			if(x1 >= 0 && y1 >= 0 && x1 < n && y1 < n ) 
			{
				if(!visit[x1][y1] && num[a][b] >= 100 && num[a][b] % 100 ==0 )
				{
					if(matrix[a][b] - k > matrix[x1][y1]) {
						if(num[a][b] % 100 == 0)
						{
							num[x1][y1] = num[a][b]+1;
							if(max < num[x1][y1]/100)
								max = num[x1][y1]/100;
							dfs(x1,y1);
							num[x1][y1] = 0;
							if(max > realmax)
							{
								realmax = max;
							}
							visit[x1][y1] = false;
						}
					}
				}
				else if(!visit[x1][y1] && matrix[x1][y1] < matrix[a][b] ) {
//					if(num[a][b] >= 100 && num[a][b] % 100 == 0)
//					{
//						num[x1][y1] = num[a][b]+1;
//						if(max < num[x1][y1]/100 + 1)
//							max = num[x1][y1]/100 + 1;
//						dfs(x1,y1);
//						num[x1][y1] = 0;
//						if(max > realmax)
//						{
//							realmax = max;
//						}
//						visit[x1][y1] = false;
//					}
					if(num[a][b] >= 100)
					{
						num[x1][y1] = num[a][b]+1;
						if(max < num[x1][y1]/100 + num[x1][y1]%100)
							max = num[x1][y1]/100 + num[x1][y1] % 100;
						dfs(x1,y1);
						num[x1][y1] = 0;
						if(max > realmax)
						{
							realmax = max;
						}
						visit[x1][y1] = false;
					}
					else 
					{
						num[x1][y1] = num[a][b]+1;
						if(max < num[x1][y1])
							max = num[x1][y1];
						dfs(x1,y1);
						num[x1][y1] = 0;
						if(max > realmax)
						{
							realmax = max;
						}
						visit[x1][y1] = false;
					}
				}
				else if(!visit[x1][y1] && matrix[x1][y1] - k < matrix[a][b] && num[a][b] < 100) 
				{
					num[x1][y1] = num[a][b] + 1;
					if(max < num[x1][y1])
						max = num[x1][y1];
					num[x1][y1] *= 100;
					dfs(x1,y1);
					num[x1][y1] = 0;
					if(max > realmax)
					{
						realmax = max;
					}
					visit[x1][y1] = false;

				}
			}
		}
	}



	static void bfs() 
	{
		int x = qx1.peek();
		int y = qy1.peek();
		visit[x][y] = true;
		num[x][y] = 1;
		while(!qx1.isEmpty()){
			x = qx1.poll();
			y = qy1.poll();
			for (int i = 0; i < 4; i++) 
			{
				int x1 = x + xx[i];
				int y1 = y + yy[i];
				//				System.out.println(x + y);
				if(x1 >= 0 && y1 >= 0 && x1 < n && y1 < n) 
				{
					if(num[x][y] % 100 != 0 && !visit[x1][y1] && matrix[x1][y1] < matrix[x][y])
					{
						//						if()
						//						{
						visit[x1][y1] = true;
						//						System.out.println(x1 + " x1 " + y1 );
						num[x1][y1] = num[x][y]+1;
						if(max < num[x1][y1] && num[x1][y1] < 100)
						{
							//								for (int j = 0; j < n; j++) {
							//									for (int j2 = 0; j2 < n; j2++) {
							//										System.out.print(num[j][j2]);
							//									}
							//									System.out.println();
							//								}
							//								System.out.println();
							max = num[x1][y1];
						}
						else if(num[x1][y1] >= 100 && num[x1][y1] % 100+num[x1][y1]/100 > max)
						{
							max = num[x1][y1]%100+num[x1][y1]/100;
						}
						qx1.add(x1);
						qy1.add(y1);
						//						}
					}
					else if(num[x][y] % 100 == 0 && !visit[x1][y1] && matrix[x1][y1] < matrix[x][y] - k)
					{
						//						if()
						//						{
						visit[x1][y1] = true;
						//						System.out.println(x1 + " x1 " + y1 );
						num[x1][y1] = num[x][y]+1;
						if(max < num[x1][y1] && num[x1][y1] < 100)
						{
							//								for (int j = 0; j < n; j++) {
							//									for (int j2 = 0; j2 < n; j2++) {
							//										System.out.print(num[j][j2]);
							//									}
							//									System.out.println();
							//								}
							//								System.out.println();
							max = num[x1][y1];
						}
						else if(num[x1][y1] >= 100 && num[x1][y1] % 100+num[x1][y1]/100 > max)
						{
							max = num[x1][y1]%100+num[x1][y1]/100;
						}
						qx1.add(x1);
						qy1.add(y1);
						//						}
					}
					else if(!visit[x1][y1] && matrix[x1][y1] - k < matrix[x][y] && num[x][y] < 100)
					{
						visit[x1][y1] = true;
						num[x1][y1] = num[x][y] + 1;
						if(max < num[x1][y1])
						{
							max = num[x1][y1];
						}
						num[x1][y1] *= 100;

						qx1.add(x1);
						qy1.add(y1);
					}
				}
			}
		}
	}
}

