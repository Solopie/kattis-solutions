import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numLogs = sc.nextInt();
        while (numLogs != -1) {
            int previousHour = 0;
            int totalMiles = 0;
            while (numLogs-- > 0) {
                int loggedSpeed = sc.nextInt();
                int loggedHour = sc.nextInt();

                totalMiles += loggedSpeed * (loggedHour - previousHour);
                previousHour = loggedHour;
            }

            System.out.println(totalMiles + " miles");
            numLogs = sc.nextInt();
        }
    }
}
