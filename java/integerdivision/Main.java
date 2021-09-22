import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        HashSet<Integer> results = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int curNum = sc.nextInt();
            if (results.contains(curNum)) {

            }
            results.add(curNum / d);
        }
    }
}
