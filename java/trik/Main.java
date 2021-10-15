import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        int ballIndex = 1;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'A') {
                if (ballIndex == 1) {
                    ballIndex = 2;
                } else if (ballIndex == 2) {
                    ballIndex = 1;
                }
            } else if (word.charAt(i) == 'B') {
                if (ballIndex == 2) {
                    ballIndex = 3;
                } else if (ballIndex == 3) {
                    ballIndex = 2;
                }
            } else if (word.charAt(i) == 'C') {
                if (ballIndex == 1) {
                    ballIndex = 3;
                } else if (ballIndex == 3) {
                    ballIndex = 1;
                }
            }
        }

        System.out.println(ballIndex);
    }
}
