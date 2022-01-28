import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String a = sc.next();
        String b = sc.next();

        if (n % 2 == 0) {
            if (a.equals(b)) {
                System.out.println("Deletion succeeded");
            } else {
                System.out.println("Deletion failed");
            }
        } else {
            boolean correct = true;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    correct = false;
                    break;
                }
            }

            if (correct) {
                System.out.println("Deletion succeeded");
            } else {
                System.out.println("Deletion failed");
            }
        }
    }
}
