import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] directions = new int[][] { { 0, -1, 0 }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, 0, -1 }, { 1, 0, 0 },
            { -1, 0, 0 } };

    public static class Pos {
        int l;
        int r;
        int c;
        int count;

        public Pos(int l, int r, int c, int count) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String args[]) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (l != 0 && r != 0 && c != 0) {
            char[][][] dungeon = new char[l][r][c];
            boolean[][][] visited = new boolean[l][r][c];

            Pos start = null;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    st = new StringTokenizer(br.readLine());
                    String curLine = st.nextToken();
                    for (int k = 0; k < c; k++) {
                        dungeon[i][j][k] = curLine.charAt(k);
                        if (dungeon[i][j][k] == 'S') {
                            start = new Pos(i, j, k, 0);
                            visited[i][j][k] = true;
                        } else if (dungeon[i][j][k] == '#') {
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            ArrayDeque<Pos> pq = new ArrayDeque<>();

            pq.add(start);

            boolean found = false;
            while (pq.size() != 0) {
                Pos pos = pq.remove();
                // Add every direction if possible to the pq
                if (dungeon[pos.l][pos.r][pos.c] == 'E') {
                    // System.out.println("Escaped in " + (pos.count) + " minute(s).");
                    sb.append("Escaped in " + (pos.count) + " minute(s).\n");
                    found = true;
                    break;
                }

                // visited[pos.l][pos.r][pos.c] = true;

                for (int i = 0; i < directions.length; i++) {
                    int newL = pos.l - directions[i][0];
                    int newR = pos.r - directions[i][1];
                    int newC = pos.c - directions[i][2];
                    Pos temp = new Pos(newL, newR, newC, pos.count + 1);

                    if (newL >= 0 && newL < dungeon.length && newR >= 0 && newR < dungeon[0].length && newC >= 0
                            && newC < dungeon[0][0].length && !visited[newL][newR][newC]) {
                        visited[newL][newR][newC] = true;
                        pq.add(temp);
                    }
                }

                // // North
                // if (pos.r - 1 >= 0 && !visited[pos.l][pos.r - 1][pos.c]) {
                // visited[pos.l][pos.r - 1][pos.c] = true;
                // pq.add(new Pos(pos.l, pos.r - 1, pos.c, pos.count + 1));
                // }
                // // East
                // if (pos.c + 1 < dungeon[0][0].length && !visited[pos.l][pos.r][pos.c + 1]) {
                // pq.add(new Pos(pos.l, pos.r, pos.c + 1, pos.count + 1));
                // }
                // // South
                // if (pos.r + 1 < dungeon[0].length && !visited[pos.l][pos.r + 1][pos.c]) {
                // pq.add(new Pos(pos.l, pos.r + 1, pos.c, pos.count + 1));
                // }
                // // West
                // if (pos.c - 1 >= 0 && !visited[pos.l][pos.r][pos.c - 1]) {
                // pq.add(new Pos(pos.l, pos.r, pos.c - 1, pos.count + 1));
                // }
                // // Up
                // if (pos.l + 1 < dungeon.length && !visited[pos.l + 1][pos.r][pos.c]) {
                // pq.add(new Pos(pos.l + 1, pos.r, pos.c, pos.count + 1));
                // }
                // // Down
                // if (pos.l - 1 >= 0 && !visited[pos.l - 1][pos.r][pos.c]) {
                // pq.add(new Pos(pos.l - 1, pos.r, pos.c, pos.count + 1));
                // }
            }

            if (!found) {
                // System.out.println("Trapped!");
                sb.append("Trapped!\n");
            }

            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }

        System.out.print(sb);
    }
}
