import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] sums = new int[5];
        int maxSum = -1;
        int maxIndex = -1;
        for (int i = 0; i < sums.length; i++) {
            String[] nums = sc.nextLine().split(" ");
            for (int j = 0; j < nums.length; j++) {
                sums[i] += Integer.parseInt(nums[j]);
            }

            if (maxSum < sums[i]) {
                maxSum = sums[i];
                maxIndex = i;
            }
        }

        System.out.println(maxIndex + 1 + " " + maxSum);
    }
}
