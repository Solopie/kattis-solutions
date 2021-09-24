import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] angles = new int[n];
        for (int i = 0; i < angles.length; i++) {
            angles[i] = sc.nextInt();
        }

        int[] targets = new int[k];
        for (int i = 0; i < targets.length; i++) {
            targets[i] = sc.nextInt();
        }

        // Generate the sums
        HashSet<Integer> sums = new HashSet<Integer>();
        sums.add(0);
        HashSet<Integer> prevSums = new HashSet<Integer>();
        prevSums.add(0);

        int prevSumSize = sums.size();
        while (true) {
            HashSet<Integer> tempSums = new HashSet<Integer>();

            for (int i = 0; i < angles.length; i++) {
                for (Integer s : prevSums) {
                    tempSums.add((s + angles[i]) % 360);
                    tempSums.add((s - angles[i] + 360) % 360);
                }
            }

            sums.addAll(tempSums);

            if (sums.size() == prevSumSize) {
                break;
            }

            prevSums = new HashSet<Integer>(tempSums);
            prevSumSize = sums.size();
        }

        for (int i = 0; i < targets.length; i++) {
            if (sums.contains(targets[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
