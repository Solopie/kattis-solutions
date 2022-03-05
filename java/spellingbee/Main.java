import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String letters = sc.next();
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        wordLoop: while (n-- > 0) {
            String word = sc.next();

            boolean hasCenter = false;
            for (int i = 0; i < word.length(); i++) {
                // Ensure the current character is in the given letters
                boolean validLetter = false;
                for (int j = 0; j < letters.length(); j++) {
                    if (word.charAt(i) == letters.charAt(j)) {
                        validLetter = true;

                        // If it's the first letter in letters than the word contains the center letter
                        if (j == 0) {
                            hasCenter = true;
                        }
                        break;
                    }
                }
                // There is a letter that isn't in letters in the word
                if (!validLetter) {
                    continue wordLoop;
                }
            }

            // Doesn't have center letter or isn't more than 4 letters
            if (!hasCenter || word.length() < 4) {
                continue;
            }

            sb.append(word + "\n");
        }

        System.out.print(sb);
    }
}
