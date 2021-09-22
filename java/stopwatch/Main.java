import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n % 2 != 0) {
            System.out.println("still running");
            return;
        }

        int total = 0;
        while (n > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            total += b - a;
            n -= 2;
        }

        System.out.println(total);
    }
}