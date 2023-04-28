import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String a = sc.next();
            String b = sc.next();
            sb.append(a + "\n");
            sb.append(b + "\n");

            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n\n");
        }

        System.out.print(sb);
    }
}
