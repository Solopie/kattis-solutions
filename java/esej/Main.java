import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        ArrayList<Character> startWord = new ArrayList<>();
        startWord.add('a');
        ArrayList<String> vocab = new ArrayList<String>();

        int size = b / 2;
        if (b / 2 < a) {
            size = a;
        }

        generateWords(size, vocab, startWord);

        for (int i = 0; i < vocab.size() - 1; i++) {
            System.out.print(vocab.get(i) + " ");
        }
        System.out.println(vocab.get(vocab.size() - 1));
    }

    // Create permutations
    public static ArrayList<String> generateWords(int n, ArrayList<String> result, ArrayList<Character> word) {
        StringBuilder strWord = new StringBuilder(word.size());
        for (Character c : word) {
            strWord.append(c);
        }
        result.add(strWord.toString());

        if (n == 0) {
            return result;
        }

        if (word.get(word.size() - 1) == 'z') {
            word.add('a');
        } else {
            char tempChar = (char) ((int) word.get(word.size() - 1).charValue() + 1);
            word.set(word.size() - 1, tempChar);
        }

        return generateWords(n - 1, result, word);
    }

    public static void createWords(int n, ArrayList<Character>) {

    }
}