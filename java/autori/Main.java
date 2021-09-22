import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split("-");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i].charAt(0));
        }
    }
}