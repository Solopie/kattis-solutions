import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();

        System.out.println(Math.round((d * (5280.0 / 4854)) * 1000));
    }
}
