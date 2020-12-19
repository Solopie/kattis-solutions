import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for(int i = 0; i < numCases; i++) {
            int caseNum = sc.nextInt();
            int days = sc.nextInt();

            int total = days;
            for(int j = 1; j <= days; j++) {
                total += j;
            }
            System.out.println(caseNum + " " + total);
        }
    }
}
