import java.util.*;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int capacity = sc.nextInt();
        int numGroups = sc.nextInt();

        int total = 0;
        int numRejected = 0;
        while (numGroups-- > 0) {
            String action = sc.next();
            int group = sc.nextInt();

            if (action.equals("enter")) {
                if (total + group > capacity) {
                    numRejected++;
                } else {
                    total += group;
                }
            } else if (action.equals("leave")) {
                total -= group;
            }
        }

        System.out.println(numRejected);
    }
}
