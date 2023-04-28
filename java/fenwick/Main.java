import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] a = new long[n + 1];
        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int target = Integer.parseInt(st.nextToken());

            if (op.equals("+")) {
                target++;
                int val = Integer.parseInt(st.nextToken());

                while (target < a.length) {
                    a[target] += val;
                    target += target & -target;
                }
            } else {
                long sum = 0;
                while (target > 0) {
                    sum += a[target];
                    target -= target & -target;
                }

                sb.append(sum + "\n");
            }
        }

        System.out.print(sb);
    }
}
