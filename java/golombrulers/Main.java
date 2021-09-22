import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = bf.readLine();
        outer: while (line != null && !line.isEmpty()) {
            // String line = sc.nextLine();
            String[] strArr = line.split(" ");
            int[] nums = new int[strArr.length];

            int big = -1;
            for (int i = 0; i < strArr.length; i++) {
                nums[i] = Integer.parseInt(strArr[i]);
                big = Math.max(big, nums[i]);
            }

            HashSet<Integer> diffs = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (diffs.contains(Math.abs(nums[j] - nums[i]))) {
                        sb.append("not a ruler\n");
                        line = bf.readLine();
                        continue outer;
                    }
                    diffs.add(Math.abs(nums[j] - nums[i]));
                }
            }

            ArrayList<Integer> missing = new ArrayList<Integer>();
            for (int i = 1; i < big; i++) {
                if (!diffs.contains(i)) {
                    missing.add(i);
                }
            }

            if (missing.size() == 0) {
                sb.append("perfect\n");
            } else {
                sb.append("missing");
                for (Integer i : missing) {
                    sb.append(" " + i);
                }
                sb.append("\n");
            }

            line = bf.readLine();
        }

        System.out.print(sb);
    }
}
