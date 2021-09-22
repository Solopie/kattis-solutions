import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // index -> [total, length]
        int[][] data = new int[n][2];
        int c = sc.nextInt();
        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j <= i; j++) {
                // Add to total and length of subarray if it doesn't surpass limit
                if (data[j][0] + fruits[i] <= c) {
                    data[j][0] += fruits[i];
                    data[j][1]++;
                }
            }
        }

        // Find biggest length
        int biggest = -1;
        for (int i = 0; i < data.length; i++) {
            biggest = Math.max(biggest, data[i][1]);
        }
        System.out.println(biggest);
    }
}
