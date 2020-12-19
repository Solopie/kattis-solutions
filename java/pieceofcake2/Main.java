import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int v = sc.nextInt();

        System.out.println(Math.max(h * v, Math.max(h * (n - v), Math.max(v * (n - h), (n - v) * (n - h)))) * 4);
    }
}
