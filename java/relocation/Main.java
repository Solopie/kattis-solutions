import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] positions = new int[n + 1];
        for (int i = 1; i < positions.length; i++) {
            positions[i] = sc.nextInt();
        }

        while (q-- > 0) {
            int action = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (action == 1) {
                positions[a] = b;
            } else {
                System.out.println(Math.abs(positions[a] - positions[b]));
            }
        }
    }
}
