import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String[] nums = sc.nextLine().split(" ");
            int result = 0;

            for (int i = 0; i < nums.length - 2; i++) {
                int prevNum = Integer.parseInt(nums[i]);
                int curNum = Integer.parseInt(nums[i + 1]);
                int bound = prevNum * 2;
                if (curNum - bound > 0) {
                    result += curNum - bound;
                }
            }

            System.out.println(result);
        }
    }
}