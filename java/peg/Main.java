import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        char[][] grid = new char[7][7];
        ArrayList<Integer[]> dots = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 7; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == '.') {
                    dots.add(new Integer[] { i, j });
                }
            }
        }

        int moves = 0;
        for (Integer[] d : dots) {
            int row = d[0];
            int col = d[1];

            // Left
            if (inGrid(row - 2, col) && grid[row - 2][col] == 'o' && grid[row - 1][col] == 'o') {
                moves++;
            }
            // Right
            if (inGrid(row + 2, col) && grid[row + 2][col] == 'o' && grid[row + 1][col] == 'o') {
                moves++;
            }
            // Up
            if (inGrid(row, col - 2) && grid[row][col - 2] == 'o' && grid[row][col - 1] == 'o') {
                moves++;
            }
            // Down
            if (inGrid(row, col + 2) && grid[row][col + 2] == 'o' && grid[row][col + 1] == 'o') {
                moves++;
            }
        }
        System.out.println(moves);
    }

    public static boolean inGrid(int row, int col) {
        if (row < 0 || row > 6 || col < 0 || col > 6) {
            return false;
        }

        if (row < 2 || row > 4) {
            if (col < 2 || col > 4) {
                return false;
            }
        }

        return true;
    }
}
