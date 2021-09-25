import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String line = sc.next();

        String first = line.substring(0, line.length() / 2);
        String second = line.substring(line.length() / 2);

        int firstSum = getSum(first);
        int secondSum = getSum(second);

        String firstFinal = rotateChars(first, firstSum);
        String secondFinal = rotateChars(second, secondSum);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < firstFinal.length(); i++) {
            int firstIndex = firstFinal.charAt(i) - 'A';
            int secondIndex = secondFinal.charAt(i) - 'A';
            result.append((char) ((firstIndex + secondIndex) % 26 + 'A'));
        }

        System.out.println(result);
    }

    public static int getSum(String word) {
        int total = 0;
        for (int i = 0; i < word.length(); i++) {
            total += word.charAt(i) - 'A';
        }

        return total;
    }

    public static String rotateChars(String word, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append((char) ((word.charAt(i) - 'A' + key) % 26 + 'A'));
        }

        return sb.toString();
    }

}
