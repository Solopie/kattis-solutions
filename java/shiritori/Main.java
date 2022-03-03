import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        boolean playerOne = false;
        boolean fair = true;

        int n = sc.nextInt() - 1;

        HashSet<String> usedWords = new HashSet<>();

        String prevWord = sc.next();
        usedWords.add(prevWord);
        while (n-- > 0) {
            String curWord = sc.next();
            // Word is already used in previous turn
            if (usedWords.contains(curWord)) {
                fair = false;
                break;
            }

            // Word does not match requirement for last and first letter of words
            if (prevWord.charAt(prevWord.length() - 1) != curWord.charAt(0)) {
                fair = false;
                break;
            }

            playerOne = !playerOne;
            usedWords.add(curWord);
            prevWord = curWord;
        }

        if (!fair) {
            if (playerOne) {
                System.out.println("Player 1 lost");
            } else {
                System.out.println("Player 2 lost");
            }
        } else {
            System.out.println("Fair Game");
        }
    }
}
