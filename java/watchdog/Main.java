import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int s = sc.nextInt();
            int h = sc.nextInt();

            int[][] hatches = new int[h][2];

            for (int i = 0; i < hatches.length; i++) {
                hatches[i] = new int[] { sc.nextInt(), sc.nextInt() };
            }

            boolean foundLength = false;
            loop: for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {

                    // Get the max distance leash has to be to reach hashes from current position
                    double maxLength = 0;
                    for (int k = 0; k < hatches.length; k++) {
                        int xDist = Math.abs(hatches[k][0] - i);
                        int yDist = Math.abs(hatches[k][1] - j);
                        maxLength = Math.max(Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2)), maxLength);
                    }

                    if (i - maxLength >= 0 && i + maxLength < s && j - maxLength >= 0 && j + maxLength < s) {
                        System.out.println(i + " " + j);
                        foundLength = true;
                        break loop;
                    }
                }
            }

            if (!foundLength) {
                System.out.println("poodle");
            }
        }
    }
}
