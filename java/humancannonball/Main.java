import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double[] start = { sc.nextFloat(), sc.nextFloat() };
        double[] dest = { sc.nextFloat(), sc.nextFloat() };

        int numCannons = sc.nextInt();

        double[][] spots = new double[numCannons + 2][2];
        // Start location (index 0)
        spots[0] = start;
        // End location (index 1)
        spots[1] = start;

        for (int i = 2; i < numCannons; i++) {
            spots[i] = new double[] { sc.nextFloat(), sc.nextFloat() };
        }

        double[][] weights = new double[numCannons][numCannons];

        for (int i = 0; i < spots.length; i++) {
            for (int j = i; j < spots[i].length; j++) {

                if (i != j) {
                    double tempDist = Math
                            .sqrt(Math.pow(spots[i][0] - spots[j][0], 2) + Math.pow(spots[i][1] - spots[j][1], 2));
                    if (i == 0) { // Start to every other node (just walking)
                        double tempResult = tempDist / 5;
                        weights[i][j] = tempResult;
                        weights[j][i] = tempResult;
                    } else { // Everything that includes cannon (only start will not have cannon)
                        // Calculate time for weight
                    }

                }
            }
        }

    }
}
