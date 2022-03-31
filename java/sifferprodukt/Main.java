import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if (x < 10) {
            System.out.println(x);
        } else {
            System.out.println(solve(numToList(x)));
        }

    }

    public static int solve(ArrayList<Integer> n) {
        if (n.size() == 1) {
            return n.get(0);
        }

        int total = 1;
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i) != 0) {
                total *= n.get(i);
            }
        }

        return solve(numToList(total));
    }

    public static ArrayList<Integer> numToList(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (n != 0) {
            arr.add(n % 10);
            n /= 10;
        }

        return arr;
    }
}
