import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int w = sc.nextInt();

        int total = 0;
        char[] result = new char[l];
        StringBuilder sb = new StringBuilder();
        boolean done = false;

        for (int i = 0; i < l; i++) {
            char curChar = 'z';

            if (total + 'z' > w) {
                curChar = (char) ('z' - (l - i));
                sb.append(curChar);

                // End with the rest as 'a'
                for (int j = i + 1; j < l; j++) {
                    sb.append('a');
                }
                done = true;
                break;
            }

            sb.append(curChar);
            total += curChar;
        }

        if (done || total == w) {
            System.out.println(sb);
        } else {
            System.out.println("impossible");
        }

    }
}
