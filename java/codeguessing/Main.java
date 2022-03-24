import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int q = sc.nextInt();

        // 0 -> p, p -> q, q -> 10

        int leftRange = p - 1;
        int midRange = (q - p) - 1;
        int rightRange = (10 - q) - 1;

        String line = sc.next();

        boolean valid = false;
        switch (line) {
            case "ABBA":
                if (midRange == 2) {
                    System.out.println((p + 1) + " " + (p + 2));
                    valid = true;
                }
                break;
            case "ABAB":
                if (midRange == 1 && rightRange == 1) {
                    System.out.println((p + 1) + " " + (q + 1));
                    valid = true;
                }
                break;
            case "BABA":
                if (leftRange == 1 && midRange == 1) {
                    System.out.println((p - 1) + " " + (q - 1));
                    valid = true;
                }
                break;
            case "AABB":
                if (rightRange == 2) {
                    System.out.println((q + 1) + " " + (q + 2));
                    valid = true;
                }
                break;
            case "BAAB":
                if (leftRange == 1 && rightRange == 1) {
                    System.out.println((p - 1) + " " + (q + 1));
                    valid = true;
                }
                break;
            case "BBAA":
                if (leftRange == 2) {
                    System.out.println((p - 2) + " " + (p - 1));
                    valid = true;
                }
                break;
        }

        if (!valid) {
            System.out.println(-1);
        }

    }
}
