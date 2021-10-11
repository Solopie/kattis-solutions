import java.util.*;

public class Main {
    static int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 0, 0 } };

    static class Grid {
        boolean[][] grid;
        int count;
        int[] prevSquare;

        public Grid(boolean[][] g, int count, int[] prevSquare) {
            this.grid = g;
            this.count = count;
            this.prevSquare = prevSquare;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        while (p-- > 0) {

            // True is black
            boolean[][] target = new boolean[3][3];

            for (int i = 0; i < target.length; i++) {
                String line = sc.next();
                for (int j = 0; j < target[i].length; j++) {
                    char cur = line.charAt(j);
                    if (cur == '*') {
                        target[i][j] = true;
                    }
                }
            }

            boolean[][] start = new boolean[3][3];

            ArrayDeque<Grid> queue = new ArrayDeque<>();
            queue.add(new Grid(start, 0, new int[] { -1, -1 }));

            HashSet<Integer> prevStates = new HashSet<Integer>();

            while (queue.size() != 0) {
                Grid cur = queue.remove();

                // ID for the current state
                int id = genInt(cur.grid);
                if (prevStates.contains(id)) {
                    continue;
                }

                prevStates.add(id);

                if (isEqual(cur.grid, target)) {
                    System.out.println(cur.count);
                    break;
                }
                for (int i = 0; i < cur.grid.length; i++) {
                    for (int j = 0; j < cur.grid[i].length; j++) {
                        // Don't press the previous square to go backwards
                        if (i != cur.prevSquare[0] || j != cur.prevSquare[1]) {
                            boolean[][] temp = cloneGrid(cur.grid);
                            for (int k = 0; k < moves.length; k++) {
                                int tempX = i + moves[k][0];
                                int tempY = j + moves[k][1];
                                if (tempX >= 0 && tempX < temp.length && tempY >= 0 && tempY < temp[0].length) {
                                    temp[tempX][tempY] = !temp[tempX][tempY];
                                }
                            }
                            queue.add(new Grid(temp, cur.count + 1, new int[] { i, j }));

                        }
                    }
                }
            }
        }
    }

    public static int genInt(boolean[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    // Black is true
    public static boolean isEqual(boolean[][] grid, boolean[][] target) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean[][] cloneGrid(boolean[][] grid) {
        boolean[][] result = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result[i][j] = grid[i][j];
            }
        }

        return result;
    }

}
