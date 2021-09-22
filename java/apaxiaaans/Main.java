import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(l.charAt(0));
        for (int i = 1; i < l.length(); i++) {
            if (l.charAt(i) != l.charAt(i - 1)) {
                sb.append(l.charAt(i));
            }
        }

        System.out.println(sb);
    }
}
