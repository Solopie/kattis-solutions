import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            int numCities = sc.nextInt();
            HashSet<String> cities = new HashSet<>();
            for (int j = 0; j < numCities; j++) {
                cities.add(sc.next());
            }
            System.out.println(cities.size());
        }
    }
}
