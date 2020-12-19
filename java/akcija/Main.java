import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> nums = new ArrayList<Integer>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        Collections.sort(nums);

        int total = 0;
        int count = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (count != 2) {
                total += nums.get(i);
                count++;
            } else {
                count = 0;
            }
        }

        System.out.println(total);
    }
}
