import java.util.Scanner;

public class tournament {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double n = s.nextDouble();
        double k = s.nextDouble();
        double i = s.nextDouble();
        int count = 0;
        while (k != i) {
            if (k + i <= 3) {
                count++;
                break;
            }
            if (n % 2 == 0) {
                k = Math.round(k / 2.0);
                i = Math.round(i / 2.0);
                n = Math.round(n / 2.0);
                count++;
            }

        }
        System.out.println(count);
    }
}
