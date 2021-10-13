import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int zr = sc.nextInt();
        int zc = sc.nextInt();

        char[][] grid = new char[r * zr][c * zc];

        for (int i = 0; i < grid.length; i += zr) {
            String line = sc.next();
            for (int j = 0; j < grid[i].length; j += zc) {
                for (int k = 0; k < zr; k++) {
                    for (int l = 0; l < zc; l++) {
                        grid[i + k][j + l] = line.charAt(j / zc);
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
