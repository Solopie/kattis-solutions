import java.util.*;

public class Main {
    static int[][] moves = new int[][] { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 },
            { -1, -2 } };

    static class Pos {
        int r;
        int c;
        int count;

        public Pos(int x, int y, int count) {
            this.r = x;
            this.c = y;
            this.count = count;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Pos start = null;
        int n = sc.nextInt();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String curLine = sc.next();
            for (int j = 0; j < n; j++) {
                if (curLine.charAt(j) == '#') {
                    visited[i][j] = true;
                } else if (curLine.charAt(j) == 'K') {
                    start = new Pos(i, j, 0);
                }
            }
        }

        ArrayDeque<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.r][start.c] = true;

        while (queue.size() != 0) {
            Pos cur = queue.remove();
            if (cur.r == 0 && cur.c == 0) {
                System.out.println(cur.count);
                return;
            }

            for (int i = 0; i < moves.length; i++) {
                int newR = cur.r + moves[i][0];
                int newC = cur.c + moves[i][1];
                if (newR >= 0 && newR < visited.length && newC >= 0 && newC < visited[0].length
                        && !visited[newR][newC]) {
                    Pos temp = new Pos(newR, newC, cur.count + 1);
                    visited[newR][newC] = true;
                    queue.add(temp);
                }
            }
        }

        System.out.println(-1);

    }
}
