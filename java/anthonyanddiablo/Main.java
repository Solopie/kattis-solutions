import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double n = sc.nextDouble();

        double radius = n / (2 * Math.PI);

        if (Math.PI * Math.pow(radius, 2) >= a) {
            System.out.println("Diablo is happy!");
        } else {
            System.out.println("Need more materials!");
        }
    }
}
