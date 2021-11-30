import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();

        int minCost = -1;
        for (int i = 0; i < h; i++) {
            int p = sc.nextInt();
            for (int j = 0; j < w; j++) {
                int a = sc.nextInt();
                if (a >= n && b >= p * n) {
                    if (minCost == -1) {
                        minCost = p * n;
                    } else {
                        minCost = Math.min(p * n, minCost);
                    }
                }
            }
        }

        if (minCost == -1) {
            System.out.println("stay home");
        } else {
            System.out.println(minCost);
        }

    }
}
