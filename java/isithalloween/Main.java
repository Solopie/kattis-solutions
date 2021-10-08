import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        if (line.equals("OCT 31") || line.equals("DEC 25")) {
            System.out.println("yup");
        } else {
            System.out.println("nope");
        }
    }
}
