import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(Integer.toBinaryString(sc.nextInt()));
        System.out.println(Integer.parseInt(String.valueOf(s.reverse()), 2));
    }
}
