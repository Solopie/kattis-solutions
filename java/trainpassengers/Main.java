import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int capacity = sc.nextInt();
        int stops = sc.nextInt();

        int numPeople = 0;

        boolean possible = true;

        for (int i = 0; i < stops; i++) {
            int left = sc.nextInt();
            int enter = sc.nextInt();
            int stay = sc.nextInt();

            // The last stop will have special cases
            if (i == stops - 1) {
                numPeople -= left;
                if (numPeople != 0) {
                    possible = false;
                    break;
                }
                if (enter != 0 || stay != 0) {
                    possible = false;
                    break;
                }
            } else {
                // People leave the train
                numPeople -= left;
                if (numPeople < 0) { // Ensure there is always positive amount of people
                    possible = false;
                    break;
                }

                // People enter the train
                numPeople += enter;
                if (numPeople > capacity) {
                    possible = false;
                    break;
                }

                // There should be no one staying in vain
                int seatsLeft = capacity - numPeople;
                if (seatsLeft > 0 && stay > 0) {
                    possible = false;
                    break;
                }

            }
        }

        if (possible) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
    }
}
