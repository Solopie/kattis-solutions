import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // children
        int m = sc.nextInt(); // toys
        int p = sc.nextInt(); // category

        HashMap<Integer, HashSet<Integer>> kids = new HashMap<>();
        int[][] categories = new int[p][];
        int[] r = new int[p];

        for (int i = 1; i <= n; i++) {
            int numToys = sc.nextInt();
            kids.put(i, new HashSet<>());
            for (int j = 0; j < numToys; j++)
                kids.get(i).add(sc.nextInt());
        }

        for (int c = 0; c < p; c++) {
            int l = sc.nextInt();
            categories[c] = new int[l];
            for (int j = 0; j < l; j++) {
                categories[c][j] = sc.nextInt();
            }
            r[c] = sc.nextInt();
        }

    }
}
/*
ford-fulkerson method

while there is a path from the source vertex to the sink vertex:
    the flow through the network can be increased by the minimum capacity edge along the path

termination results in max flow

residual capacity

a - 50 -> b b -> sink min was 10

a - 45 -> b
a <- 5 - b


source

1 -> 1 -> a
  -v

  -^  
2 -> 2 -^

3 -> 3

4 -^

sink
