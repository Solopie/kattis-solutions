import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String letters = sc.next();
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        while(n-- > 0) {
            String word = sc.next();

            int countContains = 0;
            boolean hasCenter = false;

            boolean onlyGivenLetters = true;
            for(int i = 0; i < word.length(); i++) {
                boolean hasGivenLetter = false;
                for(int j = 0; j < letters.length(); j++) {
                    if(letters.charAt(j) == word.charAt(i)) {
                        if(j == 0) {
                            hasCenter = true;
                        }
                        countContains++;
                        hasGivenLetter = true;
                        break;
                    } 
                }
                if(!hasGivenLetter) {
                    onlyGivenLetters = false;
                    break;
                }
            }

            // Contains the center character and more than or equal to 4 characters
            if(onlyGivenLetters && hasCenter && countContains >= 4) {
                sb.append(word + "\n");
            }

        }

        System.out.print(sb);
    }
}
