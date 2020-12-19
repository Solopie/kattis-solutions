import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        for(int i = 0; i < numCases; i++) {
            int k = sc.nextInt();
            int result = 0;
            for(int j = 0; j < k; j++) {
                if(j == k - 1) {
                    result += sc.nextInt();
                } else {
                    result += sc.nextInt() - 1;
                }
            }
            System.out.println(result);
        }
    }
}




