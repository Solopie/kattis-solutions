import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            boolean startsHex = false;
            if (line.substring(0, 2).equals("0x") || line.substring(0, 2).equals("0X")) {
                startsHex = true;
            }
            String[] parts = line.split("(?=0x|0X)");

            for (int i = 0; i < parts.length; i++) {
                if (i == 0 && !startsHex) {
                    continue;
                }

                int validIndex = 0;
                for (int j = 2; j < parts[i].length(); j++) {
                    if (validHexChar(parts[i].charAt(j))) {
                        validIndex = j;
                    } else {
                        break;
                    }

                    if (validIndex > 7) {
                        break;
                    }
                }

                System.out.println(
                        parts[i].substring(0, validIndex) + " " + Integer.parseInt(parts[i].substring(0, validIndex)));

            }
        }
    }

    public static boolean validHexChar(char a) {
        if (a >= '0' && a <= '9') {
            return true;
        }

        if (a >= 'a' && a <= 'f') {
            return true;
        }

        if (a >= 'A' && a <= 'F') {
            return true;
        }

        return false;
    }
}
