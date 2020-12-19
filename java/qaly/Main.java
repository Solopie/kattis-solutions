import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float qalyTotal = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            float quality = sc.nextFloat();
            float years = sc.nextFloat();
            float qaly = quality * years;
            qalyTotal += qaly;
        }
        System.out.printf("%.3f", qalyTotal);
    }
}