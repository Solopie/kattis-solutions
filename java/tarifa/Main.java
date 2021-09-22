import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numPerMonth = sc.nextInt();
        int numMonths = sc.nextInt();
        int[] months = new int[numMonths];
        months[0] = numPerMonth - sc.nextInt();
        for (int i = 1; i < months.length; i++) {
            months[i] = months[i - 1] + numPerMonth - sc.nextInt();
        }
        int result = numPerMonth + months[months.length - 1];
        System.out.println(result);
    }
}
