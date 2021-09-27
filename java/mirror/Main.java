import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();

            String[] lines = new String[r];
            for (int j = 0; j < r; j++) {
                lines[j] = sc.nextLine();
            }

            System.out.println("Test " + i);
            for (int j = r - 1; j >= 0; j--) {
                for (int k = c - 1; k >= 0; k--) {
                    System.out.print(lines[j].charAt(k));
                }
                System.out.println();
            }
        }

    }
}
