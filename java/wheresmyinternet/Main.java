import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!adj.containsKey(a)) {
                adj.put(a, new HashSet<Integer>());
            }
            if (!adj.containsKey(b)) {
                adj.put(b, new HashSet<Integer>());
            }
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(adj, visited, 1);

        ArrayList<Integer> notVisited = new ArrayList<Integer>();
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                notVisited.add(i);
            }
        }

        if (notVisited.size() == 0) {
            System.out.println("Connected");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (Integer i : notVisited) {
            sb.append(i + "\n");
        }

        System.out.print(sb);
    }

    public static void dfs(HashMap<Integer, HashSet<Integer>> adj, boolean[] visited, int house) {
        if (visited[house]) {
            return;
        }
        visited[house] = true;

        if (adj.containsKey(house)) {
            for (Integer i : adj.get(house)) {
                dfs(adj, visited, i);
            }
        }

    }
}
