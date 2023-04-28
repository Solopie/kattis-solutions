import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static class State {
        int level;
        int count;

        public State(int l, int c) {
            this.level = l;
            this.count = c;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(s);

        int[] visited = new int[l + 1];
        visited[curLevel] = 1;

        while (queue.size() != 0) {
            Integer curLevel = queue.remove();

            // Invalid level
            if (curLevel < 1 || curLevel > f) {
                continue;
            }

            if (state.level == g) {
                System.out.println(visited[curLevel]);
                return;
            } else if (visited[curLevel] != 0) {
                // Get rid of path if there's a cycle
                continue;
            }

            if (visited[curLevel + u] != 0)
                visited[curLevel + u] = visited[curLevel] + 1;

            // Go up
            queue.add(new State(state.level + u, state.count + 1));
            // Go down
            queue.add(new State(state.level - d, state.count + 1));
        }

        System.out.println("use the stairs");

    }
}
