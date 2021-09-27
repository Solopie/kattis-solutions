import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 1; i < nums.length; i++) {
            int gcd = gcd(nums[0], nums[i]);
            System.out.println(nums[0] / gcd + "/" + nums[i] / gcd);
        }
    }

    public static int gcd(int a, int b) {
        int result = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }

        return result;
    }
}
