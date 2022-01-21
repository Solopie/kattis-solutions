import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numMaps = sc.nextInt();
        int numWords = sc.nextInt();
        HashMap<Character, HashSet<Character>> mappings = new HashMap<>();

        for (int i = 0; i < numMaps; i++) {
            Character tempKey = sc.next().charAt(0);
            if (!mappings.containsKey(tempKey)) {
                mappings.put(tempKey, new HashSet<Character>());
            }
            mappings.get(tempKey).add(tempKey);
            mappings.get(tempKey).add(sc.next().charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        words: for (int i = 0; i < numWords; i++) {
            String orig = sc.next();
            String translate = sc.next();

            if (orig.length() != translate.length()) {
                sb.append("no\n");
                continue words;
            }

            for (int j = 0; j < orig.length(); j++) {
                if (!canTranslate(mappings, orig.charAt(j), translate.charAt(j), new HashSet<Character>())) {
                    sb.append("no\n");
                    continue words;
                }
            }

            sb.append("yes\n");
        }

        System.out.print(sb);
    }

    public static boolean canTranslate(HashMap<Character, HashSet<Character>> mappings, char orig, char target,
            HashSet<Character> visited) {
        if (visited.contains(orig)) {
            return false;
        }
        visited.add(orig);
        HashSet<Character> chars = mappings.getOrDefault(orig, new HashSet<Character>(Arrays.asList(orig)));
        boolean result = false;
        if (!chars.contains(target)) {
            for (Character c : chars) {
                result = result || canTranslate(mappings, c, target, visited);
            }
        } else {
            result = true;
        }

        return result;
    }
}
