import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        String name = "PER";

        int count = 0;
        for (int i = 0; i < n.length(); i += 3) {
            for (int j = 0; j < name.length(); j++) {
                if (n.charAt(i + j) != name.charAt(j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
