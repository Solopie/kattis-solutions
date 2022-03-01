import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int volume = 7;
        while(n-- > 0) {
            sc.next();
            switch(sc.next()) {
                case "op!":
                    volume++;
                    break;
                case "ned!":
                    volume--;
                    break;
            }

            volume = Math.min(10, volume);
            volume = Math.max(0, volume);
        }

        System.out.println(volume);
    }
}
