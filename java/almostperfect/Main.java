import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            long p = sc.nextInt();
            long sum = 1;

            for (long i = 2; i * i <= p; i++) {
                if (p % i == 0) {
                    sum += i;
                    if (i * i != p)
                        sum += p / i;
                }
            }

            long diff = p - sum;

            if (diff == 0) {
                System.out.println(p + " perfect");
            } else if (Math.abs(diff) <= 2) {
                System.out.println(p + " almost perfect");
            } else {
                System.out.println(p + " not perfect");
            }
        }
    }
}