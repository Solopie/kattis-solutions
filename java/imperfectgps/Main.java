import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        double totalDist = 0;
        double expDist = 0;
        int[][] pos = new int[n][3];

        for (int i = 0; i < n; i++) {
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
            pos[i][2] = sc.nextInt();
            if (i != 0)
                totalDist += Math.sqrt((pos[i][0] - pos[i - 1][0]) * (pos[i][0] - pos[i - 1][0])
                        + (pos[i][1] - pos[i - 1][1]) * (pos[i][1] - pos[i - 1][1]));
        }
        int idx = 0;
        double x = pos[0][0], y = pos[0][1];
        for (int i = t; i < pos[n - 1][2]; i += t) {
            while (pos[idx][2] < i)
                idx++;
            double changeypertime = (pos[idx][1] - pos[idx - 1][1]) / (double) (pos[idx][2] - pos[idx - 1][2]);
            double newY = (changeypertime * (i - pos[idx - 1][2])) + pos[idx - 1][1];

            double changexpertime = (pos[idx][0] - pos[idx - 1][0]) / (double) (pos[idx][2] - pos[idx - 1][2]);
            double newX = changexpertime * (i - pos[idx - 1][2]) + pos[idx - 1][0];

            expDist += Math.sqrt((newX - x) * (newX - x) + (newY - y) * (newY - y));
            x = newX;
            y = newY;
        }

        expDist += Math.sqrt((pos[n - 1][0] - x) * (pos[n - 1][0] - x) + (pos[n - 1][1] - y) * (pos[n - 1][1] - y));

        double percentage = Math.abs(totalDist - expDist) / (double) totalDist;
        System.out.println(percentage * 100);
    }
}
