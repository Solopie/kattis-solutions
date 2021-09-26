import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][5];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = sc.nextInt();
            }
            Arrays.sort(nums[i]);
        }

        int maxCount = 0;
        int multiplier = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j) {
                    boolean equal = true;
                    for (int k = 0; k < nums[i].length; k++) {
                        if (nums[i][k] != nums[j][k]) {
                            equal = false;
                            break;
                        }
                    }

                    if (equal) {
                        count++;
                    }
                }
            }
            if (maxCount < count) {
                maxCount = count;
                multiplier = 1;
            } else if (maxCount == count) {
                multiplier++;
            }
        }

        System.out.println(maxCount * multiplier);

    }
}
