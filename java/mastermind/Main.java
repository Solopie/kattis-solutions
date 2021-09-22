import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String code = sc.next();
        String guess = sc.next();
        HashMap<Character, Integer> countCode = new HashMap<Character, Integer>();
        HashMap<Character, Integer> countGuess = new HashMap<Character, Integer>();

        int r = 0;
        int s = 0;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            char g = guess.charAt(i);
            if (c == g) {
                r++;
            } else {
                countCode.put(c, countCode.getOrDefault(c, 0) + 1);
                countGuess.put(g, countGuess.getOrDefault(g, 0) + 1);

                countCode.putIfAbsent(g, 0);
                countCode.putIfAbsent(c, 0);
            }
        }

        for (Map.Entry<Character, Integer> p : countGuess.entrySet()) {
            if (p.getValue() > countCode.get(p.getKey())) {
                s += countCode.get(p.getKey());
            } else {
                s += p.getValue();
            }
        }

        System.out.println(r + " " + s);

    }
}
