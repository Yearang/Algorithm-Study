import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] tri = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                tri[i][j] = s.nextInt();
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                if (i == 0) {
                    tri[i][j] = tri[i][j];
                } else if (j - 1 != -1) {
                    tri[i][j] += max(tri[i - 1][j], tri[i - 1][j - 1]);
                } else{
                    tri[i][j] += tri[i - 1][j];
                }



//                } else if (j % 2 == 0) {
//                    tri[i][j] += tri[i - 1][j];
//                } else {
//                    tri[i][j] += tri[i - 1][j - 1];
//                }
                    if (i == n - 1 && max < tri[i][j]) {
                        max = tri[i][j];
                    }
            }
        }
        System.out.println(max);


    }

    static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
