import java.util.*;

public class Main {
    static int[][] temp = new int[][] { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 },
            { -2, -1 } };

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextInt()) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int gr = sc.nextInt();
            int gc = sc.nextInt();
            int lr = sc.nextInt();
            int lc = sc.nextInt();

            int[][] visited = new int[101][101];
            ArrayDeque<Integer> q = new ArrayDeque<Integer>();
            q.add(gr);
            q.add(gc);

            visited[gr][gc] = 1;

            boolean found = false;
            queue: while (q.size() != 0) {
                int curR = q.remove();
                int curC = q.remove();
                int level = visited[curR][curC];

                if (curR == lr && curC == lc) {
                    sb.append((level - 1) + "\n");
                    found = true;
                    break queue;
                }

                for (int i = 0; i < temp.length; i++) {
                    int newR = curR + temp[i][0];
                    int newC = curC + temp[i][1];

                    if (newR <= r && newR >= 1 && newC <= c && newC >= 1) {

                        // Check visited
                        if (visited[newR][newC] != 0) {
                            continue;
                        }

                        // Set visited
                        visited[newR][newC] = level + 1;

                        q.add(newR);
                        q.add(newC);
                    }

                }
            }

            if (!found) {
                sb.append("impossible" + "\n");
            }
        }

        System.out.print(sb);
    }
}