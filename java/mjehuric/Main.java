import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }

        while (!check(nums)) {
            algo(nums);
        }

    }

    public static void algo(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                print(nums);
            }
        }
    }

    public static boolean check(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        return true;
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[nums.length - 1]);
    }
}
