import java.util.Scanner;

public class train {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            count -= a;
            count += b;
            if (max < count) {
                max = count;
            }
        }
        System.out.println(max);
    }
}
