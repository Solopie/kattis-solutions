import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int h = sc.nextInt();

        int pos = 0;
        int count = 0;
        while (pos < h) {
            pos += a;
            count++;
            if (pos >= h) {
                break;
            }
            pos -= b;
        }

        System.out.println(count);
    }
}
