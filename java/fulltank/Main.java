import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        HashMap<Integer, HashMap<Integer, Integer>> road = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int d = sc.nextInt();
            if (!road.containsKey(u)) {
                road.put(u, new HashMap<Integer, Integer>());
            }
            if (!road.containsKey(v)) {
                road.put(v, new HashMap<Integer, Integer>());
            }
            road.get(u).put(v, d);
            road.get(v).put(u, d);
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int c = sc.nextInt();
            int s = sc.nextInt();
            int e = sc.nextInt();
            int ans = dijkstras(c, s, e, price, road);
            if (ans == Integer.MAX_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println(ans);
            }
        }
    }

    public static int dijkstras(int c, int start, int end, int[] price,
            HashMap<Integer, HashMap<Integer, Integer>> road) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[price.length];
        for (int i = 0; i < dist.length; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[start] = 0;
        pq.add(new Edge(start, 0, c));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (curr.end == end)
                return curr.weight;
            for (Map.Entry<Integer, Integer> item : road.get(curr.end).entrySet()) {
                //int temp = curr.weight + item.getValue()*price[curr.end];
                if (curr.weight + item.getValue()*price[] < dist[item.getKey()]) {
                    dist[item.getKey()] = curr.weight + item.getValue();
                    pq.add(new Edge(item.getKey(), dist[item.getKey()]));
                }
            }
        }

        return dist[end];
    }

    private class Edge implements Comparable<Edge> {
        int end;
        int weight;
        int fuelLeft;

        public Edge(int e, int w, int f) {
            end = e;
            weight = w;
            fuelLeft = f;
        }

        public int compare(Edge o) {
            return weight - o.weight;
        }
    }
}
/*
 * 5 5 10 10 20 12 13 0 1 9 0 2 8 1 2 1 1 3 11 2 3 7 2 10 0 3 20 1 4
 */
