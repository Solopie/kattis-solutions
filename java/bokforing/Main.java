import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        StringBuilder sb = new StringBuilder("");
        int[] amounts = new int[n + 1];
        int[] whenSet = new int[n + 1];

        int restartValue = 0;
        int whenRestart = 0;

        int i = 1;

        while (q-- > 0) {
            String type = sc.next();
            if (type.equals("SET")) {
                int who = sc.nextInt();
                int amount = sc.nextInt();
                amounts[who] = amount;
                whenSet[who] = i;
            } else if (type.equals("RESTART")) {
                restartValue = sc.nextInt();
                whenRestart = i;
            } else {
                int who = sc.nextInt();
                if (whenSet[who] > whenRestart) {
                    sb.append(amounts[who]);
                } else {
                    sb.append(restartValue);
                }
                sb.append("\n");
            }
            i++;
        }
        System.out.println(sb.toString());
    }
}
