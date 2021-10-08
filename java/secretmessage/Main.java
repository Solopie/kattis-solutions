import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            String message = sc.next();

            // Find next square number
            int m = message.length();
            int k = (int) Math.ceil(Math.sqrt(m));

            // int padding = m - message.length();
            char[][] grid = new char[k][k];

            int strIndex = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (strIndex < message.length()) {
                        grid[i][j] = message.charAt(strIndex);
                        strIndex++;
                    } else {
                        grid[i][j] = '*';
                    }
                }
            }

            for (int col = 0; col < grid[0].length; col++) {
                for (int row = grid.length - 1; row >= 0; row--) {
                    if (grid[row][col] != '*') {
                        System.out.print(grid[row][col]);
                    }
                }
            }
            System.out.println();
        }
    }
}
