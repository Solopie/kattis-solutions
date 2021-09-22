import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> position = new HashMap<>();
        Integer[] nums = new Integer[n];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (!position.containsKey(num)) {
                position.put(num, i);
            }
            nums[i] = num;
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                int result = count.get(o2) - count.get(o1);
                if (result == 0) {
                    if (position.get(o1) < position.get(o2)) {
                        return -1;
                    } else if (position.get(o1) > position.get(o2)) {
                        return 1;
                    }
                }
                return result;
            }
        });

        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[nums.length - 1]);

    }
}
