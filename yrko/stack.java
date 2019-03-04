import java.util.Scanner;

public class stack {
    static int c = 0;
    static int[] stack = new int[10000];

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String order;
        order = s.nextLine();
        for (int i = 0; i < n; i++) {
            order = s.nextLine();
            if (order.substring(0, 3).equals("pop")) {
                System.out.println(pop(stack));
            } else if (order.substring(0, 3).equals("top")) {
                System.out.println(top(stack));
            } else if (order.substring(0, 4).equals("push")) {
                int t = Integer.parseInt(order.substring(5, order.length()));
                push(stack, t);
            } else if (order.substring(0, 4).equals("size")) {
                System.out.println(size(stack));
            } else if (order.substring(0, 5).equals("empty")) {
                System.out.println(empty(stack));
            }
        }


    }

    public static void push(int[] l, int x) {
        l[c] = x;
        c++;
    }

    public static int pop(int[] l) {
        if (c == 0) {
            return -1;
        } else {
            c--;
            return l[c];
        }
    }

    public static int size(int[] l) {
        return c;
    }

    public static int empty(int[] l) {
        if (c == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top(int[] l) {
        if (c == 0) {
            return -1;
        } else {
            return l[c - 1];
        }
    }

}
