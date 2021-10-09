import java.util.*;

public class Main {
    static HashMap<Integer, HashMap<Integer, Integer>> savedTotals = new HashMap<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findMinTotal(nums, 0, 1) - nums[0]);
    }

    public static int findMinTotal(int[] nums, int index, int add) {
        if (savedTotals.containsKey(index) && savedTotals.get(index).containsKey(add)) {
            return savedTotals.get(index).get(add);
        }

        if (index == nums.length - 1) {
            return nums[index];
        }
        if (index > nums.length - 1 || index < 0) {
            return Integer.MAX_VALUE;
        }

        // Prepare to save total
        if (!savedTotals.containsKey(index)) {
            savedTotals.put(index, new HashMap<Integer, Integer>());
        }

        if (index + add < nums.length && index - (add - 1) >= 0 && add - 1 > 0) {
            int forwardTotal = findMinTotal(nums, index + add, add + 1);
            int backTotal = findMinTotal(nums, index - (add - 1), add);
            savedTotals.get(index).put(add, nums[index] + Math.min(forwardTotal, backTotal));
            return nums[index] + Math.min(forwardTotal, backTotal);
        }

        if (index + add < nums.length) {
            int forwardTotal = findMinTotal(nums, index + add, add + 1);
            savedTotals.get(index).put(add, nums[index] + forwardTotal);
            return nums[index] + forwardTotal;
        }

        if (add - 1 > 0 && index - (add - 1) >= 0) {
            int backTotal = findMinTotal(nums, index - (add - 1), add);
            savedTotals.get(index).put(add, nums[index] + backTotal);
            return nums[index] + backTotal;
        }

        return Integer.MAX_VALUE;
    }
}
