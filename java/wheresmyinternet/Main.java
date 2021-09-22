import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(read.readLine());

        int houses = Integer.parseInt(st.nextToken());
        int cables = Integer.parseInt(st.nextToken());

        boolean[][] connected = new boolean[houses + 1][houses + 1];
        for (int i = 0; i < cables; i++) {
            st = new StringTokenizer(read.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a][b] = true;
            connected[b][a] = true;
        }

        Boolean[] visited = new Boolean[houses + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        dfs(1, visited, connected);

        StringBuilder b = new StringBuilder();
        boolean allConnected = true;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                b.append(i + "\n");
                allConnected = false;
            }
        }

        if (allConnected) {
            System.out.println("Connected");
        } else {
            System.out.println(b);
        }
    }

    public static void dfs(int h, Boolean[] visited, boolean[][] connected) {
        if (visited[h] == true) {
            return;
        }

        visited[h] = true;

        for (int i = 1; i < visited.length; i++) {
            if (i == h) {
                continue;
            }
            if (connected[i][h]) {
                dfs(i, visited, connected);
            }
        }
    }

}
