import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String code = sc.next();
        String key = sc.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            if (i % 2 == 0) {
                result.append(moveChar(code.charAt(i), key.charAt(i), false));
            } else {
                result.append(moveChar(code.charAt(i), key.charAt(i), true));
            }
        }

        System.out.println(result);
    }

    public static char moveChar(char a, char key, boolean add) {
        int aIndex = a - 'A';
        int keyIndex = key - 'A';

        if (add) {
            return (char) ((aIndex + keyIndex) % 26 + 'A');
        } else {
            return (char) ((aIndex - keyIndex + 26) % 26 + 'A');
        }
    }
}
