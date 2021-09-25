import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double r = sc.nextDouble();
        int m = sc.nextInt();
        int c = sc.nextInt();

        while (r != 0 || m != 0 || c != 0) {
            double circleArea = Math.PI * Math.pow(r, 2);
            double squareArea = Math.pow(r * 2, 2);
            DecimalFormat numFormat = new DecimalFormat("#.########");
            System.out.println(numFormat.format(circleArea) + " " + numFormat.format(squareArea * ((double) c / m)));
            r = sc.nextDouble();
            m = sc.nextInt();
            c = sc.nextInt();
        }
    }
}
