import java.util.Scanner;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            // Count the toys
            TreeMap<String, Integer> countToys = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                String toyName = sc.next();
                int toyValue = sc.nextInt();
                countToys.put(toyName, countToys.getOrDefault(toyName, 0) + toyValue);
            }

            System.out.println(countToys.size());
            for (Map.Entry<String, Integer> toy : sortToys(countToys).entrySet()) {
                System.out.println(toy.getKey() + " " + toy.getValue());
            }
        }
    }

    public static TreeMap<String, Integer> sortToys(TreeMap<String, Integer> map) {
        Comparator<String> valueComparator = new Comparator<String>() {
            public int compare(String k1, String k2) {
                if (map.get(k1) == map.get(k2)) {
                    // Compare by alphabetical key
                    return k1.compareTo(k2);
                } else if (map.get(k1) > map.get(k2)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        TreeMap<String, Integer> result = new TreeMap<>(valueComparator);
        result.putAll(map);
        return result;
    }
}
