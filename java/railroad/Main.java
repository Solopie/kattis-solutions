import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (b % 2 == 0) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
    }

}
