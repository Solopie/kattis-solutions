import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, HashSet<Integer>> countries = new HashMap<>();

        int c = sc.nextInt();
        int p = sc.nextInt();
        int x = sc.nextInt();
        int l = sc.nextInt();

        for (int i = 0; i < p; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            countries.put(a, countries.getOrDefault(b, new HashSet<Integer>()).add(b));
            countries.put(b, countries.getOrDefault(a, new HashSet<Integer>()).add(a));
        }

        HashSet<Integer> start = new HashSet<>();
        start.add(l);
        HashSet<Integer> result = findLeavers(countries, start);

        if (result.contains(x)) {
            System.out.println("leave");
        } else {
            System.out.println("stay");
        }

    }

    // Bad because we keep re-checking
    public static HashSet<Integer> findLeavers(HashMap<Integer, HashSet<Integer>> countries, HashSet<Integer> leavers) {
        boolean addedLeaver = false;
        // Find countries with leaving partner
        for (Map.Entry<Integer, HashSet<Integer>> entry : countries.entrySet()) {
            int numLeavers = 0;
            for (Integer leaver : leavers) {
                if (entry.getValue().containsKey(leaver)) {
                    numLeavers++;
                }
            }

            // Check if half of traders are leaving to add to leavers
            if (numLeavers > entry.getValue().size() / 2) {
                leavers.add(entry.getKey());
                addedLeaver = true;
            }
        }

        // When there is no more new leavers then we are done
        if (addedLeaver) {
            return findLeavers(countries, leavers);
        } else {
            return leavers;
        }
    }
}