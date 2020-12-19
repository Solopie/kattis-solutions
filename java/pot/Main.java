import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int base = num / 10;
            int pow = num % 10;
            total += Math.pow(base, pow);
        }
        System.out.println(total);
    }
}
