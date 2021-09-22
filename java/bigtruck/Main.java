import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] locationPresents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            locationPresents[i] = sc.nextInt();
        }

        // Weights for edges
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                adjMatrix[i][j] = -1;
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            adjMatrix[a][b] = d;
            adjMatrix[b][a] = d;
        }

        // Find paths for 1 -> n and find the shortest path

    }

    public static void findPaths(int start, int end, int curWeight, ArrayList<Integer> curPath,
            ArrayList<ArrayList<Integer>> shortestPaths, int smlWeight, HashSet<Integer> visited, int[][] adjMatrix) {
        if (start == end) {
            // Update shortestPaths when we are at the end of the path
            if (curWeight < smlWeight) {
                shortestPaths.clear();
                shortestPaths.add(curPath);
                curWeight = smlWeight;
            } else if (curWeight == smlWeight) {
                shortestPaths.add(curPath);
            }
            return;
        }

        // n is also end which is how many locations there are
        for (int i = 1; i < end; i++) {
            // Check if no visited and that a edge exists
            if (!visited.contains(i) && adjMatrix[start][i] != -1) {
                // Add to visited and curPath
                visited.add(i);
                curPath.add(i);
                findPaths(i, end, curWeight + adjMatrix[start][i], curPath, shortestPaths, smlWeight, visited,
                        adjMatrix);
            }
        }
    }
}
