import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean apos = false;
        boolean bpos = false;
        if (a >= 0) {
            apos = true;
        }
        if (b >= 0) {
            bpos = true;
        }

        if (apos) {
            if (bpos) {
                System.out.println(1);
            } else {
                System.out.println(4);
            }
        } else {
            if (bpos) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
