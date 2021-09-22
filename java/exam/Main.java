import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int friendRight = sc.nextInt();
        String me = sc.next();
        String friend = sc.next();
        int friendWrong = me.length() - friendRight;

        int same = 0;
        int diff = 0;

        for (int i = 0; i < me.length(); i++) {
            if (me.charAt(i) == friend.charAt(i)) {
                same++;
            } else {
                diff++;
            }
        }

        System.out.println(Math.min(same, friendRight) + Math.min(diff, friendWrong));
    }
}
