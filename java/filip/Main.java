import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = flipInt(sc.nextInt());
        int b = flipInt(sc.nextInt());

        System.out.println(Math.max(a,b));
    }

    public static int flipInt(int num) {
        StringBuilder numString = new StringBuilder();
        numString.append(String.valueOf(num));
        int result = Integer.parseInt(numString.reverse().toString());
        return result;
    }
}
