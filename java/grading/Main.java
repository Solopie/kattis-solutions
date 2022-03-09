import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int score = sc.nextInt();

        if (score >= a) {
            System.out.println("A");
        } else if (score >= b) {
            System.out.println("B");
        } else if (score >= c) {
            System.out.println("C");
        } else if (score >= d) {
            System.out.println("D");
        } else if (score >= e) {
            System.out.println("E");
        } else {
            System.out.println("F");
        }
    }
}
