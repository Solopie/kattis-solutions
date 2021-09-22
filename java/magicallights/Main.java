import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] colors = new int[n];
        int[] parent = new int[n];
        HashMap<Integer, HashSet<Integer>> edge = new HashMap<>();
        HashSet<Integer>[] oddColors = new HashSet[n];
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
            oddColors[i] = new HashSet<Integer>();
        }

        for (int i = 1; i < n; i++) {
            parent[i] = sc.nextInt() - 1;
            if (!edge.containsKey(parent[i]))
                edge.put(parent[i], new HashSet<Integer>());
            edge.get(parent[i]).add(i);
        }
        dfs(0, colors, oddColors, edge);
        System.out.println("After dfs" + Arrays.toString(oddColors));

        while (q-- > 0) {
            int k = sc.nextInt();
            int x = sc.nextInt();
            if (k == 0) {
                System.out.println(oddColors[x].size());
            } else {
                int currColor = colors[k];
                int currNode = k;
                while (parent[currNode] != 0) {
                    if (oddColors[currNode].contains(currColor)) {
                        oddColors[currNode].remove(currColor);
                    } else {
                        oddColors[currNode].add(currColor);
                    }

                    if (oddColors[currNode].contains(x)) {
                        oddColors[currNode].remove(x);
                    } else {
                        oddColors[currNode].add(x);
                    }

                    currNode = parent[currNode];
                }
            }
        }
    }

    public static void dfs(int curr, int[] colors, HashSet<Integer>[] oddColors,
            HashMap<Integer, HashSet<Integer>> edge) {
        if (!edge.containsKey(curr)) {
            oddColors[curr].add(colors[curr]);
            return;
        }
        oddColors[curr].add(colors[curr]);

        for (Integer item : edge.get(curr)) {
            dfs(item, colors, oddColors, edge);
            for (Integer odd : oddColors[item]) {
                if (oddColors[curr].contains(odd)) {
                    oddColors[curr].remove(odd);
                } else {
                    oddColors[curr].add(odd);
                }
            }

        }
    }
}
