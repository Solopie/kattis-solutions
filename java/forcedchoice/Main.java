import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();
        int s = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while (sc.hasNextInt()) {
            int numCards = sc.nextInt();
            boolean remove = true;
            for (int i = 0; i < numCards; i++) {
                int num = sc.nextInt();
                if (num == p) {
                    remove = false;
                }
            }

            if (remove) {
                sb.append("REMOVE\n");
            } else {
                sb.append("KEEP\n");
            }
        }

        System.out.print(sb);
    }
}
