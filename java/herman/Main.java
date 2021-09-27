import java.util.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        DecimalFormat f = new DecimalFormat("#.000000");
        System.out.println(f.format(Math.PI * n * n));
        System.out.println(f.format(2 * n * n));

    }
}
