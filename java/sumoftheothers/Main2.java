import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String curLine = sc.nextLine();
            String[] strNums = curLine.split(" ");
            int[] nums = new int[strNums.length];

            for (int i = 0; i < strNums.length; i++) {
                nums[i] = Integer.parseInt(strNums[i]);
            }

            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                if (total == nums[i] * 2) {
                    System.out.println(nums[i]);
                    break;
                }
            }
        }
    }
}
