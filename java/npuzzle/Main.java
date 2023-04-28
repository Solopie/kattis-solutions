import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        char[][] orig = {
                { 'A', 'B', 'C', 'D' },
                { 'E', 'F', 'G', 'H' },
                { 'I', 'J', 'K', 'L' },
                { 'M', 'N', 'O', '.' }
        };

        char[][] given = new char[4][4];

        for (int i = 0; i < 4; i++) {
            String line = sc.next();

            for (int j = 0; j < 4; j++) {
                given[i][j] = line.charAt(j);
            }
        }

        int total = 0;
        for (int i = 0; i < orig.length; i++) {
            for (int j = 0; j < orig[i].length; j++) {
                if (i == orig.length - 1 && j == orig.length - 1) {
                    continue;
                }
                // Look for original character in given
                lookup: for (int k = 0; k < given.length; k++) {
                    for (int l = 0; l < given[k].length; l++) {
                        if (orig[i][j] == given[k][l]) {
                            total += Math.abs(i - k) + Math.abs(j - l);
                            break lookup;
                        }
                    }
                }
            }
        }

        System.out.println(total);
    }
}
