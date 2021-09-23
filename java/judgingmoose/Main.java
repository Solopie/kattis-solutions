import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (Math.max(a, b) == 0) {
            System.out.println("Not a moose");
        } else if (a == b) {
            System.out.println("Even " + a * 2);
        } else {
            System.out.println("Odd " + Math.max(a, b) * 2);
        }
    }
}
