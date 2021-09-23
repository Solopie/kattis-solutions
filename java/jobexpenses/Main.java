import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int total = 0;
        while (n-- > 0) {
            int cur = sc.nextInt();
            if (cur < 0) {
                total += cur * -1;
            }
        }

        System.out.println(total);
    }
}
