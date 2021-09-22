import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Integer> nums = new TreeSet<>();
        for (int i = 1; i <= 20; i++) {
            nums.add(i);
            nums.add(i * 2);
            nums.add(i * 3);
        }

        int[] result = new int[3];
        int[] numsArr = new int[nums.size()];
        int tempIndex = 0;
        for (Integer i : nums) {
            numsArr[tempIndex++] = i;
        }

        if (findNumsMakeZero(n, result, 0, numsArr)) {
            for (int i = 0; i < result.length; i++) {
                if (result[i] == 0) {
                    break;
                }
                if (result[i] % 2 == 0 && result[i] / 2 <= 20) {
                    System.out.println("double " + (result[i] / 2));
                } else if (result[i] % 3 == 0 && result[i] / 3 <= 20) {
                    System.out.println("triple " + (result[i] / 3));
                } else {
                    System.out.println("single " + (result[i]));
                }
            }
        } else {
            System.out.println("impossible");
        }
    }

    public static boolean findNumsMakeZero(int n, int[] result, int cur, int[] nums) {
        if (n == 0) {
            return true;
        }
        if (cur >= 3 || n < 0) {
            // Already checked if n is 0
            return false;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[cur] = nums[i];
            if (findNumsMakeZero(n - nums[i], result, cur + 1, nums)) {
                return true;
            }
        }
        return false;
    }
}
