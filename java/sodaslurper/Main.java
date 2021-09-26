import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int f = sc.nextInt();
        int c = sc.nextInt();
        
        int total = (e+f) / c;
        int empty = (e+f) / c + (e+f) % c;

        while(empty >= c) {
            total += empty / c;
            empty = empty/c + empty % c;
        }

        System.out.println(total);
    }
}
