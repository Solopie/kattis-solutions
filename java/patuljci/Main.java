import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[9];
        int total = 0;
        for(int i = 0; i < 9; i++) {
            nums[i] = sc.nextInt();
            total += nums[i];
        }

        int target = total - 100;
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(i != j) {
                    if(nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(i != result[0] && i != result[1]) {
                System.out.println(nums[i]);
            }
        }


    }
}
