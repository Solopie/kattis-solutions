import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        sc.nextLine();

        // Pos -> [Row, Col]
        char[][] grid = new char[h][w];
        boolean[][] visited = new boolean[h][w];
        int[] start = new int[2];

        for (int i = 0; i < h; i++) {
            String l = sc.nextLine();

            for (int j = 0; j < l.length(); j++) {
                grid[i][j] = l.charAt(j);
                if (l.charAt(j) == 'P') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        System.out.println(findGold(grid, visited, start));
    }

    public static int findGold(char[][] grid, boolean[][] visited, int[] pos) {
        if (visited[pos[0]][pos[1]]) {
            return 0;
        }

        visited[pos[0]][pos[1]] = true;

        if (grid[pos[0]][pos[1]] == '#') {
            return 0;
        }

        int total = 0;
        if (grid[pos[0]][pos[1]] == 'G') {
            total++;
        }

        if (!senseTrap(grid, pos)) {
            // Down
            if (pos[0] + 1 < grid.length) {
                total += findGold(grid, visited, new int[] { pos[0] + 1, pos[1] });
            }
            // Right
            if (pos[1] + 1 < grid[0].length) {
                total += findGold(grid, visited, new int[] { pos[0], pos[1] + 1 });
            }
            // Up
            if (pos[0] - 1 >= 0) {
                total += findGold(grid, visited, new int[] { pos[0] - 1, pos[1] });
            }
            // Left
            if (pos[1] - 1 >= 0) {
                total += findGold(grid, visited, new int[] { pos[0], pos[1] - 1 });
            }
        }

        return total;
    }

    public static boolean senseTrap(char[][] grid, int[] pos) {
        // Down
        if (pos[0] + 1 < grid.length && grid[pos[0] + 1][pos[1]] == 'T') {
            return true;
        }
        // Up
        if (pos[0] - 1 >= 0 && grid[pos[0] - 1][pos[1]] == 'T') {
            return true;
        }
        // Left
        if (pos[1] - 1 >= 0 && grid[pos[0]][pos[1] - 1] == 'T') {
            return true;
        }
        // Right
        if (pos[1] + 1 < grid[0].length && grid[pos[0]][pos[1] + 1] == 'T') {
            return true;
        }

        return false;
    }

}
