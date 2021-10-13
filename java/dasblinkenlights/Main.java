import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int s = sc.nextInt();

        if ((p == q && p <= s) || hasMultiple(p, q, s)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static boolean hasMultiple(int a, int b, int s) {
        HashSet<Integer> multiples = new HashSet<Integer>();
        int tempA = a;
        int tempB = b;
        while (tempA <= s || tempB <= s) {
            if (multiples.contains(tempA) || multiples.contains(tempB)) {
                return true;
            }
            if (tempA <= s) {
                multiples.add(tempA);
            }
            if (tempB <= s) {
                multiples.add(tempB);
            }

            tempA += a;
            tempB += b;
        }

        return false;
    }
}
