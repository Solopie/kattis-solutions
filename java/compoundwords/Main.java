import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> words = new HashSet<>();
        TreeSet<String> results = new TreeSet<>();
        while (sc.hasNext()) {
            words.add(sc.next());
        }

        for (String w1 : words) {
            for (String w2 : words) {
                if (!w1.equals(w2)) {
                    results.add(w1 + w2);
                    results.add(w2 + w1);
                }
            }
        }

        for (String w : results) {
            System.out.println(w);
        }

    }
}
