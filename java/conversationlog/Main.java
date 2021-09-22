import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numLines = sc.nextInt();
        sc.nextLine();

        HashMap<String, String[]> users = new HashMap<>();
        HashSet<String> wordset = new HashSet<String>();

        while (numLines-- > 0) {
            String[] line = sc.nextLine().split(" ");
            String user = line[0];
            String[] words = new String[line.length - 1];
            for (int i = 0; i < words.length; i++) {
                words[i] = line[i + 1];
                wordset.add(line[i + 1]);
            }

            if (users.containsKey(user)) {
                users.put(user, combineArray(users.get(user), words));
            } else {
                users.put(user, words);
            }
        }

        for (Map.Entry<String, String[]> e : users.entrySet()) {
            System.out.println(e.getKey() + " " + Arrays.toString(e.getValue()));
        }

        TreeMap<Integer, TreeSet<String>> result = new TreeMap<>(Collections.reverseOrder());
        for (String w : wordset) {
            boolean allContains = true;
            int count = 0;
            for (Map.Entry<String, String[]> pair : users.entrySet()) {
                if (!containsString(pair.getValue(), w)) {
                    allContains = false;
                    break;
                } else {
                    count += countWord(pair.getValue(), w);
                }
            }

            if (allContains) {
                if (!result.containsKey(count)) {
                    result.put(count, new TreeSet<String>(Collections.reverseOrder()));
                }
                result.get(count).add(w);
            }
        }

        if (result.isEmpty()) {
            System.out.println("ALL CLEAR");
        } else {
            for (Map.Entry<Integer, TreeSet<String>> entry : result.entrySet()) {
                for (String s : entry.getValue()) {
                    System.out.println(s);
                }
            }
        }

    }

    public static boolean containsString(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return true;
            }
        }

        return false;
    }

    public static int countWord(String[] arr, String target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                count++;
            }
        }

        return count;
    }

    public static String[] combineArray(String[] a, String[] b) {
        String[] result = new String[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }

        return result;
    }
}
