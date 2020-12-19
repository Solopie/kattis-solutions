import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String message = sc.next();
        System.out.println("h" + "e".repeat((message.length()-2)*2) + "y");
    }
}
