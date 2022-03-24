import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (i == 6) {
                continue;
            }
            nums.add(Integer.parseInt(line.substring(i, i + 1)));
        }

        int[] multipliers = { 4, 3, 2, 7, 6, 5, 4, 3, 2, 1 };

        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += nums.get(i) * multipliers[i];
        }

        if (total % 11 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
