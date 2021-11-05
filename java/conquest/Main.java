import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        int[] armies = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (!edges.containsKey(a)) {
                edges.put(a, new ArrayList<Integer>());
            }
            if (!edges.containsKey(b)) {
                edges.put(b, new ArrayList<Integer>());
            }

            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            int s = sc.nextInt();
            armies[i] = s;
        }

        boolean[] visited = new boolean[n + 1];
        HashSet<Integer> tryLater = new HashSet<>();

        visited[1] = true;
        int armySize = bfs(1, armies[1], edges, visited, armies, tryLater);

        if (tryLater.size() != 0) {
            int prevNumTried = -1;

            while (prevNumTried != tryLater.size()) {
                HashSet<Integer> toRemove = new HashSet<Integer>();
                HashSet<Integer> newTryLater = new HashSet<Integer>();
                for (Integer i : tryLater) {
                    if (armies[i] < armySize) {
                        // Add to army and traverse
                        toRemove.add(i);
                        armySize += armies[i];
                        armySize = bfs(i, armySize, edges, visited, armies, newTryLater);
                    }
                }
                prevNumTried = tryLater.size();
                tryLater.removeAll(toRemove);
                tryLater.addAll(newTryLater);
            }
        }

        System.out.println(armySize);
    }

    public static int bfs(int start, int armySize, HashMap<Integer, ArrayList<Integer>> edges, boolean[] visited,
            int[] armies, HashSet<Integer> tryLater) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);

        // System.out.println("----");
        // System.out.println("Start: " + start);
        while (q.size() != 0) {
            int cur = q.remove();
            // System.out.println("Cur: " + cur);
            // System.out.println("Army: " + armySize);

            // Get adjacent islands
            ArrayList<Integer> adjacent = edges.get(cur);

            // Sort by ascending army size so smaller armies are visited first
            // adjacent.sort((a, b) -> armies[a] - armies[b]);

            // System.out.println(adjacent);

            // Add to armies and visit if possible
            for (Integer i : adjacent) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                if (armies[i] >= armySize) {
                    // try later islands will be visited to avoid overlap
                    tryLater.add(i);
                    continue;
                }

                // Visit island
                armySize += armies[i];
                q.add(i);
            }
        }

        return armySize;
    }

}
