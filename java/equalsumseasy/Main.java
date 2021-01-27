import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int countNums = sc.nextInt();
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (int j = 0; j < countNums; j++) {
                nums.add(sc.nextInt());
            }

            ArrayList<ArrayList<Integer>> equalSets = findEqualSets(new ArrayList<Integer>(), new ArrayList<Integer>(),
                    nums);
            System.out.printf("Case #%d:%n", i + 1);
            if (equalSets == null) {
                System.out.println("Impossible");
            } else {
                System.out.print(equalSets.get(0).get(0));
                for (int k = 1; k < equalSets.get(0).size(); k++)
                    System.out.print(" " + equalSets.get(0).get(k));
                System.out.println();
                System.out.print(equalSets.get(1).get(0));
                for (int k = 1; k < equalSets.get(1).size(); k++)
                    System.out.print(" " + equalSets.get(1).get(k));
                System.out.println();
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> findEqualSets(ArrayList<Integer> set1, ArrayList<Integer> set2,
            ArrayList<Integer> nums) {
        int set1Total = 0;
        for (Integer i : set1) {
            set1Total += i;
        }
        int set2Total = 0;
        for (Integer i : set2) {
            set2Total += i;
        }

        if (set1Total != 0 && set1Total == set2Total) {
            return new ArrayList<>(Arrays.asList(set1, set2));
        }

        if (nums.size() == 0) {
            return null;
        }

        int curNum = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);
        ArrayList<ArrayList<Integer>> posAns = findEqualSets(set1, set2, nums);
        if (posAns != null)
            return posAns;
        set1.add(curNum);
        posAns = findEqualSets(set1, set2, nums);
        if (posAns != null)
            return posAns;
        set1.remove(set1.size() - 1);
        set2.add(curNum);
        posAns = findEqualSets(set1, set2, nums);
        if (posAns != null)
            return posAns;
        set2.remove(set2.size() - 1);
        nums.add(curNum);
        return null;
    }
}
