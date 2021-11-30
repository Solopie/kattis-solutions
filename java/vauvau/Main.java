import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            int t = sc.nextInt();
            boolean dogA = attacked(t, a, b);
            boolean dogB = attacked(t, c, d);
            if (!dogA && !dogB) {
                System.out.println("none");
            } else if (dogA && dogB) {
                System.out.println("both");
            } else {
                System.out.println("one");
            }
        }
    }

    public static boolean attacked(int t, int aggro, int calm) {
        return t % (aggro + calm) <= aggro && t % (aggro + calm) != 0;
    }
}
