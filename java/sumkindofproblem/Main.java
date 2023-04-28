import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (p-- > 0) {
            sb.append(sc.nextInt() + " ");
            int n = sc.nextInt();
            int all = 0;
            int odd = 0;
            int even = 0;
            for (int j = 1; j <= n; j++) {
                all += j;
            }
            for (int j = 0; j <= n * 2; j += 2) {
                even += j;
            }
            for (int j = 1; j <= n * 2; j += 2) {
                odd += j;
            }

            sb.append(all + " " + odd + " " + even + "\n");
        }

        System.out.print(sb);
    }
}
