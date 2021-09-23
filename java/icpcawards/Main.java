import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashSet<String> takenInstituitions = new HashSet<>();
        ArrayList<String> winningTeams = new ArrayList<>();
        while (n-- > 0 && winningTeams.size() < 12) {
            String institution = sc.next();
            String team = sc.next();

            if (!takenInstituitions.contains(institution)) {
                takenInstituitions.add(institution);
                winningTeams.add(institution + " " + team);
            }
        }

        for (String t : winningTeams) {
            System.out.println(t);
        }
    }
}
