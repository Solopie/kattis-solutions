import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // Generate targets
        ArrayList<Character> targets = new ArrayList<>();
        for (int i = (int) '0'; i <= (int) '9'; i++) {
            targets.add(Character.valueOf((char) i));
        }
        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            targets.add(Character.valueOf((char) i));
        }
        for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
            targets.add(Character.valueOf((char) i));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();

        String line = br.readLine();
        while (line != null) {
            HashMap<Character, Integer[]> targetPositions = new HashMap<>();
            ArrayList<String> grid = new ArrayList<>();
            while (line != null && !line.equals("")) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != '.') {
                        targetPositions.put(line.charAt(i), new Integer[] { grid.size(), i });
                    }
                }
                grid.add(line);
                line = br.readLine();
            }

            // Change to char[][]
            char[][] charGrid = new char[grid.size()][grid.get(0).length()];

            for (int i = 0; i < charGrid.length; i++) {
                String tempLine = grid.get(i);
                for (int j = 0; j < tempLine.length(); j++) {
                    charGrid[i][j] = tempLine.charAt(j);
                }
            }

            // Parse positions
            for (int i = 0; i < targets.size() - 1; i++) {
                Character a = targets.get(i);
                Character b = targets.get(i + 1);
                if (!targetPositions.containsKey(b)) {
                    break;
                }

                Integer[] posA = targetPositions.get(a);
                Integer[] posB = targetPositions.get(b);

                if (posA[0] == posB[0]) { // Row is equal
                    // Get min and max col
                    int big = Math.max(posA[1], posB[1]) - 1;
                    int small = Math.min(posA[1], posB[1]) + 1;
                    for (int j = small; j <= big; j++) {
                        if (charGrid[posA[0]][j] == '.') {
                            charGrid[posA[0]][j] = '-';
                        } else if (charGrid[posA[0]][j] == '|') {
                            charGrid[posA[0]][j] = '+';
                        }
                    }
                } else { // Col is equal
                    // Get min and max row
                    int big = Math.max(posA[0], posB[0]) - 1;
                    int small = Math.min(posA[0], posB[0]) + 1;
                    for (int j = small; j <= big; j++) {
                        if (charGrid[j][posA[1]] == '.') {
                            charGrid[j][posA[1]] = '|';
                        } else if (charGrid[j][posA[1]] == '-') {
                            charGrid[j][posA[1]] = '+';
                        }
                    }
                }
            }

            for (int i = 0; i < charGrid.length; i++) {
                for (int j = 0; j < charGrid[i].length; j++) {
                    // System.out.print(charGrid[i][j]);
                    result.append(charGrid[i][j]);
                }
                // System.out.println();
                result.append("\n");
            }

            if (line == null) {
                break;
            }

            // System.out.println();
            result.append("\n");

            line = br.readLine();
        }

        System.out.print(result);
    }
}
