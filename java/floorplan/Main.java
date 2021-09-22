import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int m = 1; m < n; m++) {
                if (m - k != 0 && n % (m - k) == 0) {
                    for (int k = 1; k < n; k++) {
                    System.out.println(m + " " + k);
                    return;
                }
        }

        System.out.println("impossible");

    }
}