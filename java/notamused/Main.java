import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int day = 1;
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            // OPEN
            sc.next();
            sb.append("Day " + day + "\n");

            TreeMap<String, Integer> enterTimes = new TreeMap<>();
            TreeMap<String, Integer> totalTime = new TreeMap<>();

            String action = sc.next();
            while (!action.equals("CLOSE")) {
                String person = sc.next();
                int val = sc.nextInt();

                switch (action) {
                    case "ENTER":
                        enterTimes.put(person, val);
                        break;
                    case "EXIT":
                        totalTime.put(person, totalTime.getOrDefault(person, 0) + (val - enterTimes.get(person)));
                }

                // Becomes CLOSE
                action = sc.next();
            }

            for (Map.Entry<String, Integer> entry : totalTime.entrySet()) {
                sb.append(entry.getKey() + " $" + String.format("%.2f", entry.getValue() / 10.0) + "\n");
            }
            sb.append("\n");
            day++;
        }

        System.out.print(sb);
    }
}
