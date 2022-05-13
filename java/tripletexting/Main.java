import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int wordLength = s.length() / 3;

        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < s.length(); i += wordLength) {
            words.add(s.substring(i, i + wordLength));
        }

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    System.out.println(words.get(i));
                    return;
                }
            }
        }
    }
}
