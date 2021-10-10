import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        // Ids
        int a;
        int b;

        Double weight;

        public Edge(int a, int b, double w) {
            this.a = a;
            this.b = b;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight.compareTo(other.weight);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();
        int p = sc.nextInt();

        double[][] points = new double[n + 1][2];
        for (int i = 1; i <= n; i++) {
            points[i][0] = sc.nextDouble();
            points[i][1] = sc.nextDouble();
        }

        // Nodes in MST
        boolean[] mst = new boolean[n + 1];

        int numEdges = 0;
        int[] subtrees = new int[n + 1];
        for (int i = 1; i < subtrees.length; i++) {
            subtrees[i] = i;
        }

        // Add existing edges
        for (int i = 1; i <= e; i++) {
            for (int j = i + 1; j <= e; j++) {
                // Check if they are not in same subtree
                if (findParent(subtrees, i) != findParent(subtrees, j)) {
                    // I know j will always be bigger than i
                    union(subtrees, j, i);
                    numEdges++;
                    mst[i] = true;
                    mst[j] = true;

                }
            }
        }
        for (int i = 0; i < p; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // Check if they are not in same subtree
            if (findParent(subtrees, b) != findParent(subtrees, a)) {
                // I know b will always be bigger than a
                union(subtrees, a, b);
                numEdges++;
                mst[a] = true;
                mst[b] = true;
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Track nodes that aren't in MST yet but have the edge added before
        boolean[] used = new boolean[n + 1];
        // Generate all possible edges for nodes not used and their weights
        for (int i = 1; i < mst.length; i++) {
            for (int j = 1; j < points.length; j++) {
                if (i != j && !used[j]) {
                    double curWeight = Math.sqrt(Math.pow(Math.abs(points[i][0] - points[j][0]), 2)
                            + Math.pow(Math.abs(points[i][1] - points[j][1]), 2));
                    pq.add(new Edge(i, j, curWeight));
                    used[i] = true;
                }
            }
        }

        // Add edges that don't create cycles and end when MST created
        double totalWeight = 0;
        while (pq.size() != 0) {
            Edge cur = pq.poll();

            // Check for cycle
            if (findParent(subtrees, cur.a) == findParent(subtrees, cur.b)) {
                continue;
            }

            // Add edge
            numEdges++;
            totalWeight += cur.weight;

            union(subtrees, cur.a, cur.b);

            if (numEdges == n - 1) {
                break;
            }
        }

        System.out.println(totalWeight);
    }

    public static int findParent(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }

        return findParent(parent, parent[i]);
    }

    public static void union(int[] parent, int a, int b) {
        int pA = findParent(parent, a);
        int pB = findParent(parent, b);

        if (pA > pB) {
            parent[pA] = pB;
        } else {
            parent[pB] = pA;
        }
    }
}
