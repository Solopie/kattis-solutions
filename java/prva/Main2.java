import java.util.*;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] grid = new char[r][c];
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = line.charAt(j);
            }

            String[] tempWords = line.split("#{1,}");
            for (int j = 0; j < tempWords.length; j++) {
                words.add(tempWords[j]);
            }
        }

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                sb.append(grid[i][j]);
            }

            String[] tempWords = sb.toString().split("#{1,}");

            for (int j = 0; j < tempWords.length; j++) {
                words.add(tempWords[j]);
            }
        }

        Collections.sort(words);

        System.out.println(words.get(0));

    }
}
