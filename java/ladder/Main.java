import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int v = sc.nextInt();

        System.out.println((int) Math.ceil(h / Math.sin(v * (Math.PI / 180))));
    }
}
