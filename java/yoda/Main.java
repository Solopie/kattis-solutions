import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // Power of 10 to add digit in right place
        int digitN = 0;
        int digitM = 0;

        int resultN = 0;
        int resultM = 0;

        // Check that at least a digit has been included for each number
        boolean hasDigitN = false;
        boolean hasDigitM = false;

        // Iterate from least significant digit
        while (n != 0 || m != 0) {
            int curDigitN = n % 10;
            int curDigitM = m % 10;

            if (curDigitN == curDigitM) {
                resultN += curDigitN * Math.pow(10, digitN);
                resultM += curDigitM * Math.pow(10, digitM);
                digitN++;
                digitM++;
                hasDigitN = true;
                hasDigitM = true;
            } else if (curDigitN > curDigitM) {
                resultN += curDigitN * Math.pow(10, digitN);
                digitN++;
                hasDigitN = true;
            } else {
                resultM += curDigitM * Math.pow(10, digitM);
                digitM++;
                hasDigitM = true;
            }

            n /= 10;
            m /= 10;
        }

        if (hasDigitN) {
            System.out.println(resultN);
        } else {
            System.out.println("YODA");
        }
        if (hasDigitM) {
            System.out.println(resultM);
        } else {
            System.out.println("YODA");
        }
    }
}
