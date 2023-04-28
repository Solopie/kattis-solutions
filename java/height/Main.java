import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sc.nextInt() + " ");
            ArrayList<Integer> nums = new ArrayList<>();

            int total = 0;
            for (int j = 0; j < 20; j++) {
                total += add(nums, sc.nextInt());
            }

            sb.append(total + "\n");
        }

        System.out.print(sb);
    }

    public static int add(ArrayList<Integer> nums, int num) {
        int indexAdd = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > num) {
                indexAdd = i;
                break;
            }
        }

        nums.add(indexAdd, num);
        return nums.size() - 1 - indexAdd;
    }

}
