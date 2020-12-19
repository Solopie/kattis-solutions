import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int curNum = sc.nextInt();
            if(curNum % 2 == 0) {
                System.out.println(curNum + " is even");
            } else {
                System.out.println(curNum + " is odd");
            }
        }
    }
}
