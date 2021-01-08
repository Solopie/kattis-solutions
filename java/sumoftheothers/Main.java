import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String curLine = sc.nextLine();
            String[] strNums = curLine.split(" ");
            int[] nums = new int[strNums.length];

            for(int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strNums[i]);
            }

            System.out.println(findSum(nums));
        }
    }

    public static int findSum(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(i != j) {
                    tempSum += nums[j];
                }
            }
            if(nums[i] == tempSum) {
                return nums[i];
            }
        }
        
        // Failed
        System.out.println("Failed");
        return 0;
    }
}
