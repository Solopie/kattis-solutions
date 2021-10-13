import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashSet<String> used = new HashSet<>();
        while (sc.hasNextLine()) {
            String[] words = sc.nextLine().split(" ");

            for (int i = 0; i < words.length; i++) {
                String w = words[i].toLowerCase();
                if (i != words.length - 1) {
                    if (used.contains(w)) {
                        sb.append(". ");
                    } else {
                        used.add(w);
                        sb.append(words[i] + " ");
                    }
                } else {
                    if (used.contains(w)) {
                        sb.append(".");
                    } else {
                        used.add(w);
                        sb.append(words[i]);
                    }
                }
            }

            sb.append("\n");

        }

        System.out.print(sb);
    }
}
