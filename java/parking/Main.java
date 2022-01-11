import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int min = -1;
        int max = 0;

        int[][] trucks = new int[3][2];
        for (int i = 0; i < 3; i++) {
            trucks[i] = new int[] { sc.nextInt(), sc.nextInt() };
            if (min == -1) {
                min = trucks[i][0];
            } else {
                min = Math.min(trucks[i][0], min);
            }
            max = Math.max(trucks[i][1], max);
        }

        int[] numTruckTimes = new int[4];
        for (int i = min; i <= max; i++) {
            int numTrucks = 0;
            for (int j = 0; j < trucks.length; j++) {
                if (i >= trucks[j][0] && i < trucks[j][1]) {
                    numTrucks++;
                }
            }

            numTruckTimes[numTrucks]++;
        }

        System.out.println(a * numTruckTimes[1] + (b * numTruckTimes[2] * 2) + (c * numTruckTimes[3] * 3));
    }
}
