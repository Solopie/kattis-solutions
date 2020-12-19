import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();
            int[] students = new int[];
        }

            int totalScore = 0;
            for (int j = 0; j < n; j++) {
                totalScore += sc.nextInt();
            }

            System.out.printf("%.3f" + "%", (float) totalScore / (float) n);

    }
}