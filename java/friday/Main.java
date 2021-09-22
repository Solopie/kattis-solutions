import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int d = sc.nextInt();
            int m = sc.nextInt();
            int[] months = new int[m];

            for (int i = 0; i < months.length; i++) {
                months[i] = sc.nextInt();
            }

            int count = 0;
            // Sunday-0 -> Saturday-6
            int day = 0;
            int totalDays = 1;

            for (int curMonth = 0; curMonth < months.length; curMonth++) {
                for (int dateOfMonth = 1; dateOfMonth <= months[curMonth]; dateOfMonth++) {

                    if (dateOfMonth == 13 && day == 5) {
                        count++;
                    }

                    totalDays++;
                    day++;
                    if (day >= 7) {
                        day = 0;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
