import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            String result = "";
            if(i % x == 0) {
                result += "Fizz";
            }
            if(i % y == 0) {
                result += "Buzz";
            }

            if(result.isEmpty()) {
                result = String.valueOf(i);
            }
            System.out.println(result);
        }
    }
}
