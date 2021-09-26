import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };
        Arrays.sort(nums);
        int diff1 = Math.abs(Math.abs(nums[1]) - Math.abs(nums[0]));
        int diff2 = Math.abs(Math.abs(nums[2]) - Math.abs(nums[1]));
        if (diff1 > diff2) {
            System.out.println(nums[0] + diff1 / 2);
        } else if (diff1 < diff2) {
            System.out.println(nums[1] + diff2 / 2);
        } else {
            System.out.println(nums[2] + diff1);
        }
    }

}
