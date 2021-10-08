import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int[] studentsA = new int[a];

            long totalA = 0;
            for (int i = 0; i < a; i++) {
                studentsA[i] = sc.nextInt();
                totalA += studentsA[i];
            }

            long totalB = 0;
            for (int i = 0; i < b; i++) {
                totalB += sc.nextInt();
            }

            double avgA = totalA / (double) a;
            double avgB = totalB / (double) b;

            int result = 0;
            for (int i = 0; i < studentsA.length; i++) {
                if (studentsA[i] > avgB && studentsA[i] < avgA) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }
}
