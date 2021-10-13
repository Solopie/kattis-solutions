import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        HashSet<String> building = new HashSet<>();
        while(n-- > 0) {
            String action = sc.next();
            String person = sc.next();

            if(action.equals("entry")) {
                if(building.contains(person)) {
                    sb.append(person + " entered (ANOMALY)\n");
                } else {
                    sb.append(person + " entered\n");
                    building.add(person);
                }
            } else {
                if(!building.contains(person)) {
                    sb.append(person + " exited (ANOMALY)\n");
                } else {
                    sb.append(person + " exited\n");
                    building.remove(person);
                }
            }

        }

        System.out.print(sb);
    }
}
