import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int position = 1;
        String moves = sc.nextLine();
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'A') {
                if (position == 1) {
                    position = 2;
                } else if (position == 2) {
                    position = 1;
                }
            } else if (moves.charAt(i) == 'B') {
                if (position == 2) {
                    position = 3;
                } else if (position == 3) {
                    position = 2;
                }
            } else if (moves.charAt(i) == 'C') {
                if (position == 3) {
                    position = 1;
                } else if (position == 1) {
                    position = 3;
                }
            }
        }
        System.out.println(position);
    }
}