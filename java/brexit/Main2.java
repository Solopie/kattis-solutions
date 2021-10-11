import java.util.*;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int p = sc.nextInt();
        int x = sc.nextInt();
        int l = sc.nextInt();

        HashMap<Integer, HashSet<Integer>> adj = new HashMap<Integer, HashSet<Integer>>();
        int[] origCounts = new int[c + 1];
        int[] curCounts = new int[c + 1];
        boolean[] falling = new boolean[c + 1];

        // Create adjacency list
        for (int i = 0; i < p; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (!adj.containsKey(a)) {
                adj.put(a, new HashSet<Integer>());
            }
            adj.get(a).add(b);
            if (!adj.containsKey(b)) {
                adj.put(b, new HashSet<Integer>());
            }
            adj.get(b).add(a);
        }

        // Get original counts of the partnerships
        for (Map.Entry<Integer, HashSet<Integer>> entry : adj.entrySet()) {
            origCounts[entry.getKey()] = entry.getValue().size();
            curCounts[entry.getKey()] = entry.getValue().size();
        }

        // Traverse through falling countries
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(l);
        falling[l] = true;

        String result = "stay";
        while (queue.size() != 0) {
            int cur = queue.remove();
            if (cur == x) {
                result = "leave";
                break;
            }

            for (Integer i : adj.get(cur)) {
                if (!falling[i]) {
                    curCounts[i]--;

                    // Check if neighbour is affected
                    if (origCounts[i] / 2 >= curCounts[i]) {
                        falling[i] = true;
                        queue.add(i);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
