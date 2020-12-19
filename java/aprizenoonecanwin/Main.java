import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Number of items
        int n = sc.nextInt();
        int minCost = sc.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }

        Arrays.sort(prices);

        int count = 0;
        boolean foundEnd = false;

        for (int i = 0; i < prices.length - 1; i++) {
            count++;
            if (prices[i] + prices[i + 1] > minCost) {
                System.out.println(count);
                foundEnd = true;
                break;
            }
        }

        if (!foundEnd) {
            if (count == 0) {
                System.out.println(1);
                System.exit(0);
            }

            System.out.println(n);
        }
    }
}
