import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();

        int remove = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == '<') {
                str[i] = ' ';
                remove++;
            } else if (remove > 0) {
                str[i] = ' ';
                remove--;
            }
        }

        String ans = new String(str).replaceAll(" ", "");
        System.out.println(ans);
        sc.close();
    }
}
