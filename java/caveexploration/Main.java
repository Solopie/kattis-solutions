import java.util.*;

public class Main {
    public static int time = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (!adj.containsKey(a)) {
                adj.put(a, new HashSet<Integer>());
            }
            if (!adj.containsKey(b)) {
                adj.put(b, new HashSet<Integer>());
            }

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            disc[i] = -1;
            low[i] = -1;
            parent[i] = -1;
        }

        ArrayList<Integer[]> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                findBridges(i, disc, low, parent, bridges, adj);
            }
        }

        // Remove bridges from graph and traverse from 0
        for (Integer[] b : bridges) {
            adj.get(b[0]).remove(b[1]);
            adj.get(b[1]).remove(b[0]);
        }

        boolean[] visited = new boolean[n];
        System.out.println(countNodes(0, visited, adj));
    }

    public static int countNodes(int u, boolean[] visited, HashMap<Integer, HashSet<Integer>> adj) {
        if (visited[u]) {
            return 0;
        }
        visited[u] = true;
        int result = 1;

        HashSet<Integer> adjList = adj.get(u);
        for (Integer v : adjList) {
            result += countNodes(v, visited, adj);
        }

        return result;
    }

    public static void findBridges(int u, int[] disc, int[] low, int[] parent, ArrayList<Integer[]> bridges,
            HashMap<Integer, HashSet<Integer>> adj) {
        disc[u] = time;
        low[u] = time;
        time++;

        HashSet<Integer> adjList = adj.get(u);
        for (Integer v : adjList) {
            if (disc[v] == -1) {
                parent[v] = u;
                findBridges(v, disc, low, parent, bridges, adj);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    bridges.add(new Integer[] { u, v });
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
