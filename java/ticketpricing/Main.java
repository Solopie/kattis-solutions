import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();

        int[][] price = new int[w][];
        int[][] seats = new int[w][];

        for (int i = w; i >= 0; i--) {
            int prices = sc.nextInt();
            price[i] = new int[prices];
            seats[i] = new int[prices];
            for (int j = 0; j < prices; j++) {
                price[i][j] = sc.nextInt();
            }
            for (int j = 0; j < prices; j++) {
                seats[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        int choosenSeats = 0;
        for (int i = 0; i < price[0].length; i++) {
            int currPrice = dp(price, seats, w - 1, n - seats[w - 1][i], price[w - 1][i] * seats[w - 1][i]);
            if (currPrice > max) {
                max = currPrice;
                choosenSeats = seats[w - 1][i];
            } else if (currPrice == max)
                choosenSeats = Math.min(seats[w - 1][i], choosenSeats);
        }
    }

    static int[][][] lookup;

    public static int dp(int[][] price, int[][] seats, int week, int curSeats, int curPrice) {
        if (currSeats <= 0) {
            return curPrice;
        }
        if (week == -1) {
            return curPrice;
        }

        int bestValue = 0;
        for (int i = 0; i < price[week].length; i++) {
            if (curSeats - seats[week][i] <= 0) {
                bestValue = Math.max(bestValue, curPrice + curSeats * price[week][i]);
                continue;
            }
            bestValue = Math.max(dp(price, seats, week - 1, curSeats - seats[week][i], curPrice + price[week][i]),
                    bestValue);
        }

        return bestValue;
    }

}

// p[week][price], s[week][seats]
// 437, 47 (3 seats left, made 437*47)
// 357,13 (0 seats left, made 437*47 + 357*3) 803,45 (0 seats left, made 437*47
// +807*3) 830,46 (0 seats left, made 437*47 + 830*3)
// 23029

// 4 195 223 439 852 92 63 15 1
// 2 811 893 76 27
// 1 638 3
// 1 940 38

// 195,92 223,63 439,15 852,1
