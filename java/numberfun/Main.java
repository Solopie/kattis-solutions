import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a + b == c || a - b == c || (double) a / b == c || (double) a * b == c) {
                System.out.println("Possible");
            } else if (b + a == c || b - a == c || (double) b / a == c || (double) b * a == c) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}