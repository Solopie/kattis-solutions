import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int iteration = sc.nextInt();
        int length = 2;
        while (iteration > 0) {
            length = length * 2 - 1;
            iteration--;
        }
        System.out.println(length * length);
    }
}
