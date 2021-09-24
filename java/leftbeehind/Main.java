import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        while (a != 0 || b != 0) {
            if (a + b == 13) {
                System.out.println("Never speak again.");
            } else if (a > b) {
                System.out.println("To the convention.");
            } else if (a < b) {
                System.out.println("Left beehind.");
            } else {
                System.out.println("Undecided.");
            }

            a = sc.nextInt();
            b = sc.nextInt();
        }
    }
}
