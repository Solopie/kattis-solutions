import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        ArrayList<Integer> primeFactors = new ArrayList<>();

        for (int i = 1; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                BigInteger a = new BigInteger(String.valueOf(i));
                if (a.isProbablePrime(1)) {
                    primeFactors.add(i);
                }
            }
        }

        BigInteger a = new BigInteger(String.valueOf(x));
        int count = 0;
        boolean changed = true;
        while (changed && !a.isProbablePrime(1)) {
            changed = false;
            for (int i = 0; i < primeFactors.size(); i++) {
                if (x % primeFactors.get(i) == 0) {
                    x = x / primeFactors.get(i);
                    count++;
                    changed = true;
                    break;
                }
            }

            a = new BigInteger(String.valueOf(x));
        }

        System.out.println(count + 1);
    }

    public static boolean isPrime(int a) {
        for (int i = 3; i < a; i++) {

        }
    }
}
