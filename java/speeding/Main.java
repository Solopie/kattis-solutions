import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Record previous speed
        n--;
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = -1;
        while (n-- > 0) {
            int c = sc.nextInt();
            int d = sc.nextInt();

            result = Math.max(result, (d - b) / (c - a));

            // Store previous speed
            a = c;
            b = d;
        }

        System.out.println(result);
    }
}
