import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int total = 0;
        float counted = 0;

        for(int i = 0; i < n; i++) {
            int points = sc.nextInt();
            if(points != -1) {
                total += points;
                counted++;
            }
        }

        System.out.println(total/counted);
    }
}

