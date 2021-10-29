import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[r][c];

        String minWord = null;
        int minVal = -1;
        for (int i = 0; i < r; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = line.charAt(j);
            }

            String[] words = line.split("#{1,}");
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() >= 2) {
                    if (minWord == null) {
                        minWord = words[j];
                    } else {
                        String temp = getSmaller(minWord, words[j]);
                        if (temp != null) {
                            minWord = temp;
                        }
                    }

                }
            }
        }

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                sb.append(grid[j][i]);
            }

            String[] words = sb.toString().split("#{1,}");
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() >= 2) {
                    if (minWord == null) {
                        minWord = words[j];
                    } else {
                        String temp = getSmaller(minWord, words[j]);
                        if (temp != null) {
                            minWord = temp;
                        }
                    }
                }
            }
        }

        System.out.println(minWord);
    }

    public static String getSmaller(String cur, String other) {
        int tempLength = Math.min(cur.length(), other.length());
        for (int i = 0; i < tempLength; i++) {
            if (cur.charAt(i) - ('a' - 1) > other.charAt(i) - ('a' - 1)) {
                return other;
            } else if (cur.charAt(i) - ('a' - 1) < other.charAt(i) - ('a' - 1)) {
                return cur;
            }
        }

        if (cur.length() < other.length()) {
            return cur;
        } else if (cur.length() > other.length()) {
            return other;
        }

        return null;
    }
}
