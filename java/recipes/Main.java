import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("Recipe # " + i + "\n");
            int r = sc.nextInt();
            int p = sc.nextInt();
            int d = sc.nextInt();

            String[] names = new String[r];
            double[] weights = new double[r];
            double[] percentages = new double[r];

            double scalingFactor = d / (double) p;
            double scaledWeight = 0;

            for (int j = 0; j < r; j++) {
                names[j] = sc.next();
                weights[j] = sc.nextDouble();
                percentages[j] = sc.nextDouble();

                if (percentages[j] == 100) {
                    scaledWeight = weights[j] * scalingFactor;
                }
            }

            for (int j = 0; j < r; j++) {
                sb.append(names[j] + " " + ((percentages[j] / 100) * scaledWeight) + "\n");
            }

            sb.append("----------------------------------------\n");
        }

        System.out.print(sb);
    }
}
