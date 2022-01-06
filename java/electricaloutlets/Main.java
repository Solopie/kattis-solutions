import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int total = 0;
            for (int i = 0; i < k; i++) {
                total += sc.nextInt();
            }
            sb.append((total - (k - 1)) + "\n");
        }
        System.out.print(sb);
    }
}
