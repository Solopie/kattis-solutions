import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        int numPeople = sc.nextInt();
        ArrayList<String> people = new ArrayList<>();
        for (int i = 0; i < numPeople; i++) {
            people.add(sc.next());
        }

        ArrayList<String> teamA = new ArrayList<>();
        ArrayList<String> teamB = new ArrayList<>();

        int curIndex = 0;
        boolean addA = true;
        while (people.size() > 0) {
            curIndex += words.length - 1;
            if (curIndex >= people.size()) {
                curIndex = curIndex % people.size();
            }
            if (addA) {
                teamA.add(people.get(curIndex));
            } else {
                teamB.add(people.get(curIndex));
            }
            people.remove(curIndex);
            addA = !addA;
        }

        System.out.println(teamA.size());
        for (String p : teamA) {
            System.out.println(p);
        }
        System.out.println(teamB.size());
        for (String p : teamB) {
            System.out.println(p);
        }

    }
}