import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] grid = new char[r][c];
        ArrayList<Integer[]> startPoints = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < line.length(); j++) {
                grid[i][j] = line.charAt(j);
                if (line.charAt(j) == 'V') {
                    startPoints.add(new Integer[] { i, j });
                }
            }
        }

        for (Integer[] point : startPoints) {
            // Make start points as if they haven't been flooded yet for termination case
            grid[point[0]][point[1]] = '.';
            flood(grid, point[0], point[1]);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void flood(char[][] grid, int r, int c) {
        // Already flooded this coordinate
        if (grid[r][c] == 'V') {
            return;
        }
        grid[r][c] = 'V';

        int rowBelow = r + 1;
        if (rowBelow < grid.length && grid[rowBelow][c] != '#') {
            flood(grid, rowBelow, c);
        } else if (rowBelow < grid.length) {
            if (c - 1 >= 0 && grid[r][c - 1] == '.') {
                flood(grid, r, c - 1);
            }
            if (c + 1 < grid[0].length && grid[r][c + 1] == '.') {
                flood(grid, r, c + 1);
            }
        }
    }
}
