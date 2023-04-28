import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();
        int k = sc.nextInt();

        double result = 0;
        double multiplier = 100;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int timestamp = sc.nextInt();
            result += (timestamp - prev) * (multiplier / 100);
            prev = timestamp;
            multiplier += p;
        }

        result += (k - prev) * (multiplier / 100.0);

        System.out.println(result);
    }
}
