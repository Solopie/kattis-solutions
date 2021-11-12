import java.util.*;

public class Main {
    public static int[][] moves = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numCase = 1;
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            char[][] grid = new char[m][n];

            for (int i = 0; i < m; i++) {
                String line = sc.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            int numStars = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '-') {
                        visitStar(grid, i, j);
                        numStars++;
                    }
                }
            }

            System.out.println("Case " + numCase + ": " + numStars);
            numCase++;
        }

    }

    public static void visitStar(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '#') {
            return;
        }
        grid[row][col] = '#';

        for (int i = 0; i < moves.length; i++) {
            visitStar(grid, row + moves[i][0], col + moves[i][1]);
        }
    }
}
