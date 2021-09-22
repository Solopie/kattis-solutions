import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Look for highest number and check how many times it occurs
        int highestNum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (highestNum < nums[i]) {
                highestNum = nums[i];
            }
        }
        System.out.println(highestNum + ".000000000");

    }

}
