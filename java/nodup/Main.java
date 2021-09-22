import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        HashSet<String> used = new HashSet<>();

        for (String w : words) {
            if (used.contains(w)) {
                System.out.println("no");
                return;
            } else {
                used.add(w);
            }
        }

        System.out.println("yes");
    }
}
