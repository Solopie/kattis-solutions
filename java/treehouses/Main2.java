import java.util.*;

public class Main2 {
    static class Edge implements Comparable<Edge> {
        int idA;
        int idB;
        Double weight;

        public Edge(int a, int b, double w) {
            this.idA = a;
            this.idB = b;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight.compareTo(other.weight);
        }

        @Override
        public String toString() {
            return idA + " " + idB + " " + weight;
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

        int[] subtrees = new int[n + 1];
        for (int i = 0; i < subtrees.length; i++) {
            subtrees[i] = i;
        }

        int numEdges = 0;
        HashMap<Integer, HashSet<Integer>> presetEdges = new HashMap<>();
        // Open to land can all walk to each other already
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e; j++) {
                if (i != j) {
                    if (!presetEdges.containsKey(i)) {
                        presetEdges.put(i, new HashSet<Integer>());
                    }
                    if (!presetEdges.get(i).contains(j)) {
                        presetEdges.get(i).add(j);
                        numEdges++;

                    }

                    // Ensure only done once per edge
                    if (!(presetEdges.containsKey(j) && presetEdges.get(j).contains(i))) {
                        // Don't care about cycles here
                        if (j > i) {
                            subtrees[j] = subtrees[i];
                        } else {
                            subtrees[i] = subtrees[j];
                        }
                    }
                }
            }
        }
        // Already created lines
        for (int i = 0; i < p; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!presetEdges.containsKey(a)) {
                presetEdges.put(a, new HashSet<Integer>());
            }
            if (!presetEdges.get(a).contains(b)) {
                presetEdges.get(a).add(b);
                numEdges++;

            }
            if (!presetEdges.containsKey(b)) {
                presetEdges.put(b, new HashSet<Integer>());
            }
            if (!presetEdges.get(b).contains(a)) {
                presetEdges.get(b).add(a);
                numEdges++;
            }

            // Don't care about cycles here and only need to add for one direction
            if (b < a) {
                subtrees[a] = subtrees[b];
            } else {
                subtrees[b] = subtrees[a];
            }
        }

        // Calculate weights and put into priority queue
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // Don't need to calculate weight for edge that already exists
                if (i != j && !(presetEdges.containsKey(i) && presetEdges.get(i).contains(j))) {
                    double edgeWeight = Math.sqrt(Math.pow(Math.abs(points[i][0] - points[j][0]), 2)
                            + Math.pow(Math.abs(points[i][1] - points[j][1]), 2));
                    pq.add(new Edge(i, j, edgeWeight));
                }
            }
        }

        // Keep trying edges in queue until MST created
        double totalWeight = 0;
        while (pq.size() != 0) {
            Edge cur = pq.poll();

            // Check if there is a cycle
            if (subtrees[cur.idA] == subtrees[cur.idB]) {
                continue;
            }

            // Add the edge to the temp graph
            if (!presetEdges.containsKey(cur.idA)) {
                presetEdges.put(cur.idA, new HashSet<Integer>());
            }
            if (!presetEdges.get(cur.idA).contains(cur.idB)) {
                presetEdges.get(cur.idA).add(cur.idB);
                numEdges++;

                // Add edge once
                if (cur.idA < cur.idB) {
                    subtrees[cur.idB] = subtrees[cur.idA];
                } else {
                    subtrees[cur.idA] = subtrees[cur.idB];
                }

            }
            if (!presetEdges.containsKey(cur.idB)) {
                presetEdges.put(cur.idB, new HashSet<Integer>());
            }
            if (!presetEdges.get(cur.idB).contains(cur.idA)) {
                presetEdges.get(cur.idB).add(cur.idA);
                numEdges++;
            }

            // Remove the edge if we find a cycle
            // boolean isCycle = false;
            // for (int i = 1; i <= n; i++) {
            // boolean[] tempVisited = new boolean[n + 1];
            // isCycle = isCycle || findCycle(i, -1, presetEdges, tempVisited);
            // }
            // if (isCycle) {
            // presetEdges.get(cur.idA).remove(cur.idB);
            // presetEdges.get(cur.idB).remove(cur.idA);
            // numEdges -= 2;
            // // Don't care about empty hashset
            // } else {
            totalWeight += cur.weight;
            // }

            // if (numEdges / 2 == n - 1) {
            // break;
            // }

            boolean finished = true;
            for (int i = 2; i < subtrees.length; i++) {
                if (subtrees[i] != subtrees[1]) {
                    finished = false;
                }
            }

            if (finished) {
                break;
            }
        }

        System.out.println(totalWeight);
    }

    // public static boolean findCycle(int id, int prevId, HashMap<Integer,
    // HashSet<Integer>> edges, boolean[] visited) {
    // if (visited[id]) {
    // return true;
    // }

    // visited[id] = true;

    // boolean result = false;
    // if (edges.containsKey(id)) {
    // HashSet<Integer> targets = edges.get(id);
    // for (Integer i : targets) {
    // if (i != prevId) {
    // result = result || findCycle(i, id, edges, visited);
    // }
    // }
    // }

    // return result;
    // }
}
