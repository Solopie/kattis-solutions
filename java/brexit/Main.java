import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        int c = sc.nextInt();
        int p = sc.nextInt();
        int x = sc.nextInt();
        int l = sc.nextInt();

        int[] origCounts = new int[c + 1];
        int[] curCounts = new int[c + 1];
        boolean[] falling = new boolean[c + 1];

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

        for (Map.Entry<Integer, HashSet<Integer>> entry : adj.entrySet()) {
            origCounts[entry.getKey()] = entry.getValue().size();
            curCounts[entry.getKey()] = entry.getValue().size();
        }

        falling[l] = true;
        boolean result = findTarget(adj, l, x, origCounts, curCounts, falling);
        if (result) {
            System.out.println("leave");
        } else {
            System.out.println("stay");
        }

    }

    // Traverse to every country that is going to die
    public static boolean findTarget(HashMap<Integer, HashSet<Integer>> adj, int cur, int target, int[] origCounts,
            int[] curCounts, boolean[] falling) {
        if (cur == target) {
            return true;
        }

        boolean result = false;
        for (Integer i : adj.get(cur)) {
            if (!falling[i]) {
                curCounts[i]--;

                if (origCounts[i] / 2 >= curCounts[i]) {
                    falling[i] = true;
                    result = result || findTarget(adj, i, target, origCounts, curCounts, falling);
                }
            }
        }

        return result;
    }
}