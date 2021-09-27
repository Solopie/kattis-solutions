import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = 1;
        boolean skipped = false;
        ;
        while (n-- > 0) {
            int cur = sc.nextInt();
            if (num != cur) {
                skipped = true;
                for (int i = num; i < cur; i++) {
                    System.out.println(i);
                }
            }
            num = cur + 1;
        }

        if (!skipped) {
            System.out.println("good job");
        }
    }
}
