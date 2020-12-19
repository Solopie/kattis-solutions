import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
    
        // (r1 + r2)/2 = s
        // r2 = s*2 - r1
        int r1 = sc.nextInt();
        int s = sc.nextInt();

        System.out.println(s*2 - r1);
    }
}
