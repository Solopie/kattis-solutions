import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int c = 1; c <= n; c++) {
            int p = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();

            Integer[] nums = new Integer[l];
            for (int i = 0; i < l; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums, Collections.reverseOrder());

            long total = 0;
            int multiplier = 1;
            int curKey = 0;

            for (int i = 0; i < nums.length; i++) {
                total += nums[i] * multiplier;
                if (++curKey == k) {
                    multiplier++;
                    curKey = 0;
                }
            }

            sb.append("Case #" + c + ": " + total + "\n");
        }

        System.out.print(sb);

    }
}
