import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int index = 1;
        while (sc.hasNextLine()) {
            String[] words = sc.nextLine().split(" ");

            int max = Integer.parseInt(words[1]);
            int min = Integer.parseInt(words[1]);

            for (int i = 1; i < words.length; i++) {
                int num = Integer.parseInt(words[i]);
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            System.out.println("Case " + index + ": " + min + " " + max + " " + (max - min));
            index++;
        }
    }
}
