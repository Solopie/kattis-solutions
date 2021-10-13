import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String p = sc.next();

        if (s.equals(p)) {
            System.out.println("Yes");
        } else if (s.equals(caseReverse(p))) {
            System.out.println("Yes");
        } else if (s.substring(0, s.length() - 1).equals(p) && Character.isDigit(s.charAt(s.length() - 1))) {
            System.out.println("Yes");
        } else if (s.substring(1, s.length()).equals(p) && Character.isDigit(s.charAt(0))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static String caseReverse(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
        }

        return sb.toString();
    }
}
