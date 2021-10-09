import java.util.*;

public class Main {
    // Top left clockwise
    static int[][] moves = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 },
            { 0, -1 } };

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        String[] lines = new String[m];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            lines[i] = sc.next();
            for (int j = 0; j < lines[i].length(); j++) {
                if (lines[i].charAt(j) == '#') {
                    visited[i][j] = false;
                } else {
                    visited[i][j] = true;
                }
            }
        }

        // Look for unvisited node
        int[] pos = getLonelyNode(visited);
        int count = 0;
        while (pos[0] != -1 || pos[1] != -1) {
            count++;
            traverse(pos[0], pos[1], visited);

            // Check if there are still unvisited nodes
            pos = getLonelyNode(visited);
        }

        System.out.println(count);

    }

    public static void traverse(int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for (int i = 0; i < moves.length; i++) {
            int newRow = row + moves[i][0];
            int newCol = col + moves[i][1];
            if (newRow < visited.length && newRow >= 0 && newCol < visited[0].length && newCol >= 0
                    && !visited[newRow][newCol]) {
                traverse(newRow, newCol, visited);
            }
        }
    }

    public static int[] getLonelyNode(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (!visited[i][j]) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }
}
