import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String simonLine = "Simon says";
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String line = sc.nextLine();

            if (line.startsWith(simonLine)) {
                sb.append(line.substring(simonLine.length(), line.length()) + "\n");
            }
        }

        System.out.print(sb);

    }
}
