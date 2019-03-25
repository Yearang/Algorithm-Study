import java.util.Scanner;

public class rotoo {
    static int k = 0;
    static int[] input;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {

            k = s.nextInt();
            if (k == 0) {
                return;
            }
            input = new int[k];
            for (int i = 0; i < input.length; i++) {
                input[i] = s.nextInt();
            }
//            combi(input, 0, k,6,0);
            int[] b = new int[6];
//            for (int i = 0; i < k; i++) {
//                dfs(i,b);
            cnt = 0;
            dfs(0);
            System.out.println();

//            }

        }
    }

    static int cnt = 0, b[] = new int[6];

    static void dfs(int a) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = a; i < input.length; i++) {
                if (cnt == -1) {
                    return;
                }
                b[cnt] = input[i];

                cnt++;
                dfs(i + 1);
            }
        }
        cnt--;
    }
//    static void dfs(int a, int [] b) {
//        if (cnt == 6) {
//            for (int i = 0; i < b.length; i++) {
//                System.out.print(b[i] + " ");
//                cnt = 0;
//            }
//            System.out.println();
//        } else {
//            for (int i = a; i < k; i++) {
//                b[cnt] = input[i];
//                cnt++;
//                dfs(i, b);
//            }
//        }
//        cnt--;
//    }

//    static void combi(int[] arr, int index, int n, int r, int target) {
//        if(r==0) {
//            for(int i=0; i<arr.length; i++)
//                System.out.print(arr[i] + " ");
//            System.out.println();
//        }else if(target == n) {
//            return;
//        }else {
//            arr[index] = target;
//            combi(arr, index+1, n, r-1, target+1);
//            combi(arr, index, n, r, target+1);
//        }
//    }
}
