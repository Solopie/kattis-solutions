import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int houses = sc.nextInt();
        int cables = sc.nextInt();

        boolean[][] connected = new boolean[houses + 1][houses + 1];
        Boolean[] connectedToOne = new Boolean[houses + 1];
        connectedToOne[1] = true;
        for (int i = 0; i < connectedToOne.length; i++) {
            if (i != 1) {
                connectedToOne[i] = false;
            }
        }

        for (int i = 0; i < cables; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            connected[a][b] = true;
            connected[b][a] = true;
            if (connectedToOne[a]) {
                connectedToOne[b] = true;
            }
            if (connectedToOne[b]) {
                connectedToOne[a] = true;
            }
            if (connectedToOne[a]) {
                connectedToOne[b] = true;
            }
        }

        Boolean[] visited = new Boolean[houses + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        dfs(1, visited, connected);

        boolean allConnected = true;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(i);
                allConnected = false;
            }
        }

        if (allConnected) {
            System.out.println("Connected");
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
