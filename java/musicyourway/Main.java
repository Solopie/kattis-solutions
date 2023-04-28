import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String[] attributes = sc.nextLine().split();
        int numSongs = sc.nextInt();
        String[][] songs = new String[numSongs][attributes.length];
        for (int i = 0; i < numSongs; i++) {
            for (int j = 0; j < attributes.length; j++) {
                songs[i][j] = sc.next();
            }
        }

    }
}
