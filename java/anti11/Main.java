import java.util.*;

public class Main {
    static int[] dp = new int[10001];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(series(n));

        }
    }

    public static int series(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 3;
        }
        return dp[n] = (series(n - 1) + series(n - 2)) % 1000000007;
    }

    // public static int count(int n, int prev) {
    // if (dp[n][prev] != 0) {
    // return dp[n][prev];
    // }

    // if (n == 0) {
    // return 1;
    // }

    // if (prev == 0) {
    // dp[n][prev] = (count(n - 1, 1) + count(n - 1, 0)) % (1000000007);
    // return dp[n][prev];
    // } else {
    // dp[n][prev] = count(n - 1, 0) % 1000000007;
    // return dp[n][prev];
    // }
    // }
}
