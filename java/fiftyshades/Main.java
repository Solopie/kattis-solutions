import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int total = 0;
        while (n-- > 0) {
            String word = sc.next();
            word = word.toLowerCase();
            if (word.contains("pink") || word.contains("rose")) {
                total++;
            }
        }

        if (total == 0) {
            System.out.println("I must watch Star Wars with my daughter");
        } else {
            System.out.println(total);
        }
    }
}