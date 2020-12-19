import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int contestants = sc.nextInt();
        int carrots = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < contestants; i++) {
            sc.nextLine();
        }
        System.out.println(carrots);
    }
}
