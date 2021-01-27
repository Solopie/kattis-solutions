import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int instructions = Integer.parseInt(sc.nextLine());
        while (instructions != 0) {
            char[] register = new char[32];
            for (int i = 0; i < register.length; i++)
                register[i] = '?';

            for (int iter = 0; iter < instructions; iter++) {
                String[] instruction = sc.nextLine().split(" ");
                String op = instruction[0];

                if (op.equals("CLEAR")) {
                    int loc = Integer.parseInt(instruction[1]);
                    register[loc] = '0';
                } else if (op.equals("SET")) {
                    int loc = Integer.parseInt(instruction[1]);
                    register[loc] = '1';
                } else if (op.equals("OR")) {
                    char i = register[Integer.parseInt(instruction[1])];
                    char j = register[Integer.parseInt(instruction[2])];
                    if (i == '1' || j == '1')
                        register[Integer.parseInt(instruction[1])] = '1';
                    else if (i == '0' && j == '0')
                        register[Integer.parseInt(instruction[1])] = '0';
                    else
                        register[Integer.parseInt(instruction[1])] = '?';
                } else if (op.equals("AND")) {
                    char i = register[Integer.parseInt(instruction[1])];
                    char j = register[Integer.parseInt(instruction[2])];
                    if (i == '0' || j == '0')
                        register[Integer.parseInt(instruction[1])] = '0';
                    else if (i == '1' && j == '1')
                        register[Integer.parseInt(instruction[1])] = '1';
                    else
                        register[Integer.parseInt(instruction[1])] = '?';
                }
            }

            for (int i = 31; i >= 0; i--)
                System.out.print(register[i]);
            System.out.println();

            instructions = Integer.parseInt(sc.nextLine());
        }
    }
}
