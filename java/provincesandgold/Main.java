import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int g = sc.nextInt();
        int s = sc.nextInt();
        int c = sc.nextInt();

        int total = g * 3 + s * 2 + c;

        if (total <= 1) {
            System.out.println("Copper");
        } else if (total == 2) {
            System.out.println("Estate or Copper");
        } else if (total <= 4) {
            System.out.println("Estate or Silver");
        } else if (total == 5) {
            System.out.println("Duchy or Silver");
        } else if (total <= 7) {
            System.out.println("Duchy or Gold");
        } else {
            System.out.println("Province or Gold");
        }
    }
}
