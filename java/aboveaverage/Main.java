import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while (c-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                total += arr[i];
            }
            double average = total / (double) n;

            int numAboveAverage = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > average) {
                    numAboveAverage++;
                }
            }

            System.out.printf("%.3f", (numAboveAverage / (double) n) * 100);
            System.out.println("%");
        }

    }
}
