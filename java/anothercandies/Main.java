import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine(); 
        while(t-- > 0) {
            long total = 0;
            int count = 0;

            String line = sc.nextLine();
            while(!line.equals("\n")) {
                System.out.println(line);

                line = sc.nextLine();
            }
            sc.nextLine();
        }
    }
}
