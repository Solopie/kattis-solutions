import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int b = sc.nextInt();
        int br = sc.nextInt();
        int bs = sc.nextInt();
        int a = sc.nextInt();
        int as = sc.nextInt();

        double bTotalSaved = (br - b) * bs;
        int offset = 0;
        if (bTotalSaved % as == 0) {
            offset++;
        }
        System.out.println(a + (int) Math.ceil(bTotalSaved / as) + offset);
    }
}
