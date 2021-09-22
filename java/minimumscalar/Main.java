import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int i = 1; i <= c; i++) {
            int n = sc.nextInt();
            long[] v1 = new long[n];
            long[] v2 = new long[n];
            for (int j = 0; j < n; j++) {
                v1[j] = Long.parseLong(sc.next());
            }
            for (int j = 0; j < n; j++) {
                v2[j] = Long.parseLong(sc.next());
            }

            Arrays.sort(v1);
            Arrays.sort(v2);

            long[] temp = new long[n];
            for (int j = 0; j < n; j++) {
                temp[j] = v1[n - 1 - j];
            }

            long result = 0;
            for (int j = 0; j < n; j++) {
                result += temp[j] * v2[j];
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}
