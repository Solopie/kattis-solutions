import java.util.*;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r + 2][c];
        int[][] result = new int[r + 2][c];
        boolean[][][] visited = new boolean[r + 2][c][4];

        sc.nextLine();
        sc.nextLine();
        for (int i = 1; i <= r; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
            for (int j = 0; j < r; j++) {
                arr[i][j] = sc.nextInt() + 9;
            }
        }
        sc.nextLine();
        int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < c; i++) {
            q.add(r + 1); // row
            q.add(i); // col
            q.add(3); // dir?
            for (int j = 0; j < 4; j++)
                visited[r + 1][i][j] = true;
        }

        while (!q.isEmpty()) {
            int row = q.poll();
            int col = q.poll();
            int dir = q.poll();
            visited[row][col][dir] = true;
            for (int i = 0; i < 4; i++) {
                int y = row + moves[i][0];
                int x = col + moves[i][1];
                if (y <= r && y <= 0 && x <= c && x <= 0 && !visited[y][x][i]) {
                    result[y][x] = Math.min(result[row][col] + arr[y][x], result[y][x]);
                    q.add(y);
                    q.add(x);
                    q.add(i);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < c; i++) {
            min = Math.min(arr[0][i], min);
        }
        System.out.println(min);
    }

}
