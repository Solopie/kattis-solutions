import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int f = sc.nextInt();
        while (f != 0) {
            int r = sc.nextInt();

            int[] ft = new int[f];
            for (int i = 0; i < f; i++) {
                ft[i] = sc.nextInt();
            }

            int[] rt = new int[r];
            for (int i = 0; i < r; i++) {
                rt[i] = sc.nextInt();
            }

            ArrayList<Double> dr = new ArrayList<Double>();
            for (int i = 0; i < ft.length; i++) {
                for (int j = 0; j < rt.length; j++) {
                    double tempDr = rt[j] / (double) ft[i];
                    dr.add(tempDr);
                }
            }

            Collections.sort(dr);

            double maxSpread = 0;
            for (int i = 0; i < dr.size() - 1; i++) {
                maxSpread = Math.max(dr.get(i + 1) / dr.get(i), maxSpread);
            }

            System.out.printf("%.2f\n", maxSpread);

            f = sc.nextInt();
        }
    }

}
