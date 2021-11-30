import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String line = sc.next();
        StringBuilder sb = new StringBuilder();

        if (line.length() % 3 != 0) {
            sb.append(convert(line.substring(0, line.length() % 3)));
        }

        for (int i = line.length() % 3; i < line.length(); i += 3) {
            sb.append(convert(line.substring(i, i + 3)));
        }
        System.out.println(sb);

    }

    public static int convert(String s) {
        int total = 0;
        int num = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                total += num;
            }
            num *= 2;
        }

        return total;
    }
}
