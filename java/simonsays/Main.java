import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while (n-- > 0) {
            String line = sc.nextLine();
            if (line.length() >= 10 && line.substring(0, 10).equals("Simon says")) {
                String[] words = line.split(" ");
                System.out.print(" ");
                for (int i = 2; i < words.length; i++) {
                    if (i == words.length - 1) {
                        System.out.print(words[i]);
                    } else {
                        System.out.print(words[i] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
