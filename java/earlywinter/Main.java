import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dm = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int curNum = sc.nextInt();
            if (curNum <= dm) {
                System.out.println("It hadn't snowed this early in " + i + " years!");
                return;
            }
        }

        System.out.println("It had never snowed this early!");
    }
}
