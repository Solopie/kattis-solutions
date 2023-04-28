import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int i = 0;

        int resultI = -1;
        int resultJ = -1;

        while (s - (i * a) > 0) {
            int excess = s - (i * a);
            if (excess % b == 0) {
                if (resultI == -1) {
                    resultI = i;
                    resultJ = excess / b;
                } else if (i + (excess / b) < resultI + resultJ) {
                    resultI = i;
                    resultJ = excess / b;
                }
            }
            i++;
        }

        if (resultI != -1) {
            System.out.println(resultI + " " + resultJ);
        } else {
            System.out.println("Impossible");
        }
    }
}
