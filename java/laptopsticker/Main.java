import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if (c <= a - 2 && d <= b - 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
