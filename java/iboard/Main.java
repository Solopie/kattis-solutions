import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String curLine = sc.nextLine();
            int numZeros = 0;
            int numOnes = 0;

            for (char c : curLine.toCharArray()) {
                String bits = Integer.toBinaryString(c);
                for (int i = bits.length() - 1; i >= 0; i--) {
                    int b = bits.charAt(i);
                    if (b == '0') {
                        numZeros++;
                    } else {
                        numOnes++;
                    }
                }

                if (bits.length() < 7) {
                    numZeros += 7 - bits.length();
                }
            }
            if (numZeros % 2 == 1 || numOnes % 2 == 1) {
                System.out.println("trapped");
            } else {
                System.out.println("free");
            }
        }
    }
}