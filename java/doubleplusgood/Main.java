import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] strNums = sc.nextLine().split("\\+");
        int[] nums = new int[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }

        System.out.println(Arrays.toString(nums));

        HashSet<Integer> sums = new HashSet<>();
        findSums(nums, 0, sums, new boolean[nums.length - 1]);
        System.out.println(sums);
        System.out.println(sums.size());

    }

    public static void findSums(int[] nums, int index, HashSet<Integer> sums, boolean[] numAdd) {
        if (index == numAdd.length) {
            sums.add(calculateSum(nums, numAdd));
            return;
        }

        numAdd[index] = false;
        findSums(nums, index + 1, sums, numAdd);
        numAdd[index] = true;
        findSums(nums, index + 1, sums, numAdd);
    }

    public static int calculateSum(int[] nums, boolean[] numAdd) {
        int total = 0;
        ArrayList<Integer> newNums = new ArrayList<>();
        System.out.println(Arrays.toString(numAdd));

        boolean joinedBefore = true;
        newNums.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1 && !joinedBefore) {
                newNums.add(nums[i]);
                break;
            }

            if (!numAdd[i - 1]) {
                if (joinedBefore) {
                    newNums.set(newNums.size() - 1, Integer
                            .parseInt(String.valueOf(newNums.get(newNums.size() - 1)) + String.valueOf(nums[i])));
                } else {
                    newNums.add(Integer.parseInt(String.valueOf(nums[i - 1]) + String.valueOf(nums[i])));
                    joinedBefore = true;
                    i++;
                }
            } else {
                newNums.add(nums[i]);
                joinedBefore = false;
            }
        }

        System.out.println(newNums);

        for (Integer n : newNums) {
            total += n;
        }

        return total;
    }
}