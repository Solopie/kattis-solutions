import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int d = -1;
        int t = -1;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i <= n - 3; i++) {
            if (d == -1 || (Math.max(nums[i], nums[i + 2]) < t)) {
                d = i + 1;
                t = Math.max(nums[i], nums[i + 2]);
            }
        }

        System.out.println(d + " " + t);
    }
}
