import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[] ontop = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        HashMap<Integer, HashSet<Integer>> edge = new HashMap<>();
        while (m-- > 0) {
            tokens = reader.readLine().split("\\s+");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            if (!edge.containsKey(a)) {
                edge.put(a, new HashSet<Integer>());
            }
            edge.get(a).add(b);
            ontop[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (ontop[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder("");
        int added = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr + "\n");
            added++;
            if (edge.containsKey(curr)) {
                for (Integer i : edge.get(curr)) {
                    ontop[i]--;
                    if (ontop[i] == 0 && !visited[i]) {
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
        }

        if (added == n) {
            System.out.print(sb.toString());
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}