import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> addresses = new TreeSet<>();
        String line = sc.next();

        String[] smiles2 = { ":)", ";)" };
        String[] smiles3 = { ":-)", ";-)" };
        main: for (int i = 0; i < line.length() - 2; i++) {
            for (int j = 0; j < smiles3.length; j++) {
                if (line.substring(i, i + 3).equals(smiles3[j])) {
                    addresses.add(i);
                    continue main;
                }
            }
            for (int j = 0; j < smiles2.length; j++) {
                if (line.substring(i, i + 2).equals(smiles2[j])) {
                    addresses.add(i);
                    continue main;
                }
            }
        }

        for (int i = 0; i < smiles2.length; i++) {
            if (line.substring(line.length() - 2, line.length()).equals(smiles2[i])) {
                addresses.add(line.length() - 2);
                break;
            }
        }

        for (Integer i : addresses) {
            System.out.println(i);
        }
    }
}
