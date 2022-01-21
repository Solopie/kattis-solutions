import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int[] sums = new int[2];
        boolean left = true;
        for (int i = n - 1; i >= 0; i--) {
            if (left) {
                sums[0] += nums[i];
            } else {
                sums[1] += nums[i];
            }

            left = !left;
        }

        System.out.println(sums[0] + " " + sums[1]);

    }
}
