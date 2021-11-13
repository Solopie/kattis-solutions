import java.util.*;

public class Main {
    public static int[][] moves = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
    public static int curLevel;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] grid = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = sc.nextInt();
                max = Math.max(max, grid[i][j]);
            }
        }

        ArrayList<Integer[]> startingPoints = new ArrayList<Integer[]>();
        startingPoints.add(new Integer[] { 0, 0 });

        int prevLevel = -1;
        curLevel = grid[n - 1][n - 1];
        while (curLevel <= max + 1) {
            if (prevLevel == curLevel) {
                curLevel++;
            }
            // System.out.println("--- Cur Level: " + curLevel);
            prevLevel = curLevel;

            if (solve(grid, visited, curLevel, startingPoints)) {
                System.out.println(prevLevel - 1);
                return;
            }
            // curLevel updated globally
        }

        throw new Exception("Lmao");
    }

    public static boolean solve(int[][] grid, boolean[][] visited, int level, ArrayList<Integer[]> startingPoints) {
        ArrayList<Integer[]> endPoints = new ArrayList<>();
        for (Integer[] start : startingPoints) {
            if (reachEnd(grid, visited, level, endPoints, start)) {
                return true;
            }
        }

        // Update startingPoints for next level
        startingPoints.clear();
        startingPoints.addAll(endPoints);

        // for (Integer[] a : startingPoints) {
        // System.out.println(Arrays.toString(a));
        // }

        return false;
    }

    public static boolean reachEnd(int[][] grid, boolean[][] visited, int level, ArrayList<Integer[]> stopped,
            Integer[] pos) {
        visited[pos[0]][pos[1]] = true;
        // System.out.println(pos[0] + " " + pos[1]);
        if (pos[0] == grid.length - 1 && pos[1] == grid[0].length - 1) {
            return true;
        }

        boolean failedDirection = false;
        boolean result = false;
        // Min of unreachable directions
        for (int i = 0; i < moves.length; i++) {
            Integer[] newPos = new Integer[] { pos[0] + moves[i][0], pos[1] + moves[i][1] };
            if (newPos[0] >= 0 && newPos[0] < grid.length && newPos[1] >= 0 && newPos[1] < grid[0].length
                    && !visited[newPos[0]][newPos[1]]) {
                if (grid[newPos[0]][newPos[1]] < level) {
                    result = result || reachEnd(grid, visited, level, stopped, newPos);
                } else {
                    if (curLevel == level) {
                        // Default to first new value that is too high
                        curLevel = grid[newPos[0]][newPos[1]] + 1;
                    } else {
                        curLevel = Math.min(curLevel, grid[newPos[0]][newPos[1]] + 1);
                    }
                    failedDirection = true;
                }
            }
        }

        if (failedDirection) {
            stopped.add(pos);
        }

        return result;
    }
}
