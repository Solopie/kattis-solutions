import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < c; i++) {
            boolean[][] grid = new boolean[3][3];

            for (int j = 0; j < 3; j++) {
                String line = sc.nextLine();
                for (int k = 0; k < line.length(); k++) {
                    char cur = line.charAt(k);
                    if (cur == '*') {
                        grid[i][k] = true;
                    } else {
                        grid[i][k] = false;
                    }
                }
            }

            boolean[][] start = new boolean[3][3];
            for (int j = 0; j < start.length; j++) {
                for (int k = 0; k < start[j].length; k++) {
                    start[j][k] = false;
                }
            }
            System.out.println(countSolve(grid, start, 0));

        }
    }

    public static int generateSolves(boolean[][] target, boolean[][] curState, int count) {
        if (equalState(target, curState)) {
            return count;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[][] tempState = copyState(curState);
                changeState(tempState, i, j);
                return countSolve(target, tempState, count + 1);
            }
        }

        return -1;
    }

    // Assumed equal size
    public static boolean equalState(boolean[][] a, boolean[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean[][] copyState(boolean[][] a) {
        boolean[][] result = new boolean[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = a[i][j];
            }
        }

        return result;
    }

    public static void changeState(boolean[][] target, int y, int x) {
        target[y][x] = !target[y][x];
        if (y != 0) {
            target[y - 1][x] = !target[y - 1][x];
        }
        if (y != 2) {
            target[y + 1][x] = !target[y + 1][x];
        }
        if (x != 0) {
            target[y][x - 1] = !target[y][x - 1];
        }
        if (x != 2) {
            target[y][x + 1] = !target[y][x + 1];
        }
    }

}
