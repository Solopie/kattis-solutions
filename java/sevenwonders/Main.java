import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        HashMap<Character, Integer> count = new HashMap<>();
        count.put('T', 0);
        count.put('C', 0);
        count.put('G', 0);
        for (int i = 0; i < line.length(); i++) {
            char curChar = line.charAt(i);
            count.put(curChar, count.get(curChar) + 1);
        }

        int minCount = -1;
        int total = 0;
        for (Integer i : count.values()) {
            if (minCount == -1 || minCount > i) {
                minCount = i;
            }
            total += Math.pow(i, 2);
        }

        total += minCount * 7;

        System.out.println(total);
    }
}
