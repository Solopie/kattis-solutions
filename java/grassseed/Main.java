import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double cost = sc.nextFloat();
        int numLawns = sc.nextInt();
        double total = 0;
        for(int i = 0; i < numLawns; i++) {
            double width = sc.nextDouble();
            double length = sc.nextDouble();
            total += cost*width*length;
        }

        System.out.printf("%.7f\n", total);
    }
}

