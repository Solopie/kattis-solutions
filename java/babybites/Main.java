import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean valid = true;
        for (int i = 1; i <= n; i++) {
            if (sc.hasNextInt()) {
                if (sc.nextInt() != i) {
                    valid = false;
                    break;
                }
            } else {
                sc.next();
            }
        }

        if (valid) {
            System.out.println("makes sense");
        } else {
            System.out.println("something is fishy");
        }
    }
}
