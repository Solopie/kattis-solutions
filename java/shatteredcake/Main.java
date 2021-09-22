import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int maxWidth = sc.nextInt();
        int n = sc.nextInt();

        int area = 0;
        while (n-- > 0) {
            int w = sc.nextInt();
            int l = sc.nextInt();

            area += w * l;
        }

        System.out.println(area / maxWidth);

    }
}
