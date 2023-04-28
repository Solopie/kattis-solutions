import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, HashSet<String>> words = new HashMap<>();
        HashMap<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String category = sc.next();
            int w = sc.nextInt();
            for (int j = 0; j < w; j++) {
                String word = sc.next();
                if (!words.containsKey(word)) {
                    words.put(word, new HashSet<String>());
                }
                words.get(word).add(category);
            }
        }

        while (sc.hasNext()) {
            String word = sc.next();

            if (!words.containsKey(word)) {
                continue;
            }

            HashSet<String> categories = words.get(word);
            for (String c : categories) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }

        int max = 0;
        ArrayList<String> maxCategories = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxCategories = new ArrayList<String>();
                maxCategories.add(entry.getKey());
            } else if (entry.getValue() == max) {
                maxCategories.add(entry.getKey());
            }
        }

        Collections.sort(maxCategories);
        for (String c : maxCategories) {
            System.out.println(c);
        }
    }
}
