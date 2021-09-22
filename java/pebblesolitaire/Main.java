import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int lines = Integer.parseInt(st.nextToken());

        for (int i = 0; i < lines; i++) {
            boolean[] game = new boolean[12];
            st = new StringTokenizer(reader.readLine());
            String l = st.nextToken();
            for (int j = 0; j < l.length(); j++) {
                if (l.charAt(j) == 'o') {
                    game[j] = false;
                } else {
                    game[j] = true;
                }
            }

            System.out.println(leastPebbles(game));
        }
    }

    public static int leastPebbles(boolean[] game) {
        ArrayList<Integer[]> moves = findMoves(game);
        if (moves.size() == 0) {
            int pebbles = 0;
            for (int i = 0; i < game.length; i++) {
                if (game[i]) {
                    pebbles++;
                }
            }
            return pebbles;
        }

        int smallest = -1;
        for (int i = 0; i < moves.size(); i++) {
            boolean[] updatedGame = makeMove(game, moves.get(i)[0], moves.get(i)[1]);
            int tempPebbles = leastPebbles(updatedGame);
            if (smallest == -1) {
                smallest = tempPebbles;
            } else {
                smallest = Math.min(smallest, tempPebbles);
            }
        }

        return smallest;
    }

    public static boolean[] makeMove(boolean[] game, int start, int dest) {
        boolean[] temp = new boolean[game.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = game[i];
        }
        temp[start] = false;
        if (start < dest) {
            temp[start + 1] = false;
            temp[start + 2] = true;
        } else {
            temp[start - 1] = false;
            temp[start - 2] = true;
        }

        return temp;
    }

    public static ArrayList<Integer[]> findMoves(boolean[] game) {
        ArrayList<Integer[]> moves = new ArrayList<>();
        ArrayList<Integer> pebbles = new ArrayList<Integer>();
        for (int i = 0; i < game.length; i++) {
            if (game[i]) {
                pebbles.add(i);
            }
        }

        for (Integer i : pebbles) {
            if (i > 1 && i < game.length - 2) {
                if (game[i - 1] == true && game[i - 2] != true) {
                    moves.add(new Integer[] { i, i - 2 });
                }

                if (game[i + 1] == true && game[i + 2] != true) {
                    moves.add(new Integer[] { i, i + 2 });
                }
            } else {
                if (i < 2) {
                    if (game[i + 1] == true && game[i + 2] != true) {
                        moves.add(new Integer[] { i, i + 2 });
                    }
                } else if (i > game.length - 3) {
                    if (game[i - 1] == true && game[i - 2] != true) {
                        moves.add(new Integer[] { i, i - 2 });
                    }
                }
            }
        }

        return moves;
    }
}
