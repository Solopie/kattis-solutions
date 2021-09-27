import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            HashMap<Integer, Integer> counts = new HashMap<>();
            int g = sc.nextInt();
            for (int j = 0; j < g; j++) {
                int cur = sc.nextInt();
                counts.put(cur, counts.getOrDefault(cur, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (entry.getValue() == 1) {
                    System.out.println("Case #" + i + ": " + entry.getKey());
                }
            }
        }

    }
}
