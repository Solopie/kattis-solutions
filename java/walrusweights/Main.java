import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> toAdd = new HashSet<>();
            for (Integer j : set) {
                if (nums[i] + j < 2000) {
                    toAdd.add(nums[i] + j);
                }
            }
            set.add(nums[i]);
            set.addAll(toAdd);
        }

        int result = 0;
        for (Integer i : set) {
            if (Math.abs(1000 - i) <= Math.abs(1000 - result)) {
                result = i;
            }
        }

        System.out.println(result);
    }

}
