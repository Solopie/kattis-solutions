import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String word = sc.next();

        HashMap<String, Integer> parts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parts.put(sc.next(), sc.nextInt());
        }

        // Generate all possible combinations
        // Find starting parts
        ArrayList<String> startingParts = new ArrayList<String>();
        for (String part : parts.keySet()) {
            if (part.equals(word.substring(0, part.length()))) {
                // Part is equal to start
                startingParts.add(part);
            }
        }

        // Create combinations from starting parts
        for (String startingPart : startingParts) {
            ArrayList<String> start = new ArrayList<String>();
            start.add(startingPart);
            System.out.println(findCombinations(word, parts.keySet(), start, new ArrayList<ArrayList<String>>()));
        }
    }

    public static ArrayList<ArrayList<String>> findCombinations(String word, Set<String> parts,
            ArrayList<String> curString, ArrayList<ArrayList<String>> result) {
        if (curString.join("").equals(word)) {
            // If we have found combination of the word then we return that
            result.add(curString);
            return result;
        }

        // Try to add part
        for (String part : parts) {
            if (word.substring(0, curString.size()).equals(curString.join(""))) {
                // Check if substring is equal, if we then we found a new part

                // Add future combinations to result and pass it down
                // Clone string for new result
                ArrayList<String> curStringClone = new ArrayList<String>();
                for (String tempString : curString) {
                    curStringClone.add(tempString);
                }
                // Add new part
                curStringClone.add(part);
                for (ArrayList<String> finalCombo : findCombinations(word, parts, curStringClone, result)) {
                    result.add(finalCombo);
                }
            }
        }

        return result;
    }
}
