import java.util.*;

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<Integer, Integer> count = new TreeMap<>(new CustomComparator());

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            count.put(cur, count.getOrDefault(cur, 0) + 1);
        }

        System.out.println(count.firstEntry());

        System.out.println();
    }
}
