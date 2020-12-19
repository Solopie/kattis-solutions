import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> variables = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] data = line.split(" ");
            if (data[0].equals("def")) {
                variables.put(data[1], Integer.parseInt(data[2]));
            } else if (data[0].equals("calc")) {
                boolean unknown = false;

                // Find any undefined variables
                for (int i = 1; i < data.length; i += 2) {
                    if (!variables.containsKey(data[i])) {
                        unknown = true;
                        break;
                    }
                }

                if (!unknown) {
                    int numResult = variables.get(data[1]);

                    // Iterate through each operator
                    for (int i = 2; i < data.length; i += 2) {
                        // Operator
                        String operator = data[i];
                        if (operator.equals("=")) {
                            boolean foundResult = false;
                            for (Map.Entry<String, Integer> entry : variables.entrySet()) {
                                if (entry.getValue() == numResult) {
                                    System.out.println(String.join(" ", Arrays.copyOfRange(data, 1, data.length)) + " "
                                            + entry.getKey());
                                    foundResult = true;
                                    break;
                                }
                            }
                            if (!foundResult) {
                                System.out.println(
                                        String.join(" ", Arrays.copyOfRange(data, 1, data.length)) + " unknown");
                            }
                            break;
                        } else if (operator.equals("+")) {
                            numResult += variables.get(data[i + 1]);
                        } else {
                            numResult -= variables.get(data[i + 1]);
                        }
                    }
                } else {
                    System.out.println(String.join(" ", Arrays.copyOfRange(data, 1, data.length)) + " unknown");
                }
            } else if (data[0].equals("clear")) {
                variables.clear();
            }
        }
    }
}
