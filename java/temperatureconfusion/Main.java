import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String[] in = sc.next().split("\\/");
        // boolean neg = false;
        int num = Integer.parseInt(in[0]);
        // if (num < 0) {
        // neg = true;
        // num *= -1;
        // }
        int denom = Integer.parseInt(in[1]);
        int a = 32 * denom;
        num -= a;
        num *= 5;
        denom *= 9;

        int gcd = gcd(Math.abs(num), Math.abs(denom));
        System.out.println((num / gcd) + "/" + (denom / gcd));
    }

    public static int gcd(int a, int b) {
        int result = Math.min(a, b);
        if (result == 0) {
            return Math.max(a, b);
        }
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }

        return result;
    }
}
