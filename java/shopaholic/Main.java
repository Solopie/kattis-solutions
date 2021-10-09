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
        long total = 0;
        for (int i = nums.length - 3; i >= 0; i -= 3) {
            total += nums[i];
        }

        System.out.println(total);
    }
}
