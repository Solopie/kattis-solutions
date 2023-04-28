import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int count = 7;
        for (int i = 0; i < n; i++) {
            String request = sc.nextLine();

            if (request.equals("Skru op!")) {
                count++;
            } else {
                count--;
            }

            count = Math.max(0, count);
            count = Math.min(10, count);
        }

        System.out.println(count);
    }
}
