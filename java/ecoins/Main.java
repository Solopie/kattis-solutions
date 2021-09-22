import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        for (int i = 0; i < p; i++) {
            int c = sc.nextInt();
            int target = sc.nextInt();

            int[][] coins = new int[c][2];
            for (int j = 0; j < values.length; j++) {
                values[j][0] = sc.nextInt();
                values[j][1] = sc.nextInt();
            }

            int result = numCoins(coins, target, 0);
        }
    }

    public static int numCoins(int[][] coins, int target, int sum) {
        if (sum == target) {
            return 0;
        }

        int result = -1;
        for (int i = 0; i < coins.length; i++) {
            // Conventional
            int total = numCoins(coins, target, sum + coins[i][0]);

            if (total == -1) {
                // Tech
                total = numCoins(coins, target, sum + coins[i][1]);
                if (total != -1) {
                    result = total;
                }
            } else {
                result = total;
            }
        }

        return result;
    }
}