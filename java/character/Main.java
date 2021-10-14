import java.util.*;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n == 0 || n == 1) {
            System.out.println(0);
            return;
        } else if (n == 2) {
            System.out.println(1);
            return;
        }

        System.out.println((int)Math.pow(2,n) - n - 1);
    }
}
