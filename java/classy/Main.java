import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int numPeople = sc.nextInt();
            HashMap<String, String[]> people = new HashMap<>();
            for (int j = 0; j < numPeople; j++) {
                String name = sc.next();
                name = name.substring(0, name.length() - 1);
                people.put(name, sc.next().split("-"));
                sc.next();
            }
            ArrayList<String> peopleRank = new ArrayList<>();
            for (Map.Entry<String, String[]> person : people.entrySet()) {
                boolean added = false;
                for (int j = 0; j < peopleRank.size(); j++) {
                    int result = compareClass(people.get(peopleRank.get(j)), person.getValue());
                    if (result == -1) {
                        peopleRank.add(j, person.getKey());
                        added = true;
                        break;
                    } else if (result == 0) {
                        if (person.getKey().compareTo(peopleRank.get(j)) < 0) {
                            peopleRank.add(j, person.getKey());
                            added = true;
                            break;
                        }
                    }
                }
                if (!added)
                    peopleRank.add(person.getKey());
            }

            for (String person : peopleRank) {
                System.out.println(person);
            }
            System.out.println("==============================");
        }
    }

    public static int compareClass(String[] class1, String[] class2) {
        int min = Math.min(class1.length, class2.length);
        for (int offset = 0; offset < min; offset++) {
            String tempClass1 = class1[class1.length - 1 - offset];
            String tempClass2 = class2[class2.length - 1 - offset];
            if (!tempClass1.equals(tempClass2)) {
                if (tempClass1.equals("upper")) {
                    return 1;
                } else if (tempClass1.equals("lower")) {
                    return -1;
                } else {
                    if (tempClass2.equals("upper")) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }
}
