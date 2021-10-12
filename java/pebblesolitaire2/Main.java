import java.util.*;

public class Main {

    static class State {
        String s;
        ArrayList<Integer[]> moves;
        int id;

        public State(String s, ArrayList<Integer[]> moves) {
            this.s = s;
            this.moves = moves;
            this.id = this.genId(s);
        }

        public int genId(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'o') {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            return Integer.parseInt(sb.toString(), 2);
        }

        public int countPebbles() {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'o') {
                    result++;
                }
            }

            return result;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            String s = sc.next();

            ArrayDeque<State> queue = new ArrayDeque<>();

            queue.add(new State(s, getMoves(s)));

            HashSet<Integer> prevStates = new HashSet<>();

            int minResult = Integer.MAX_VALUE;

            while (queue.size() != 0) {
                State cur = queue.remove();
                // System.out.println(cur.s);
                // System.out.print("[");
                // for (Integer[] z : cur.moves) {
                // System.out.print("[");
                // for (Integer i : z) {
                // System.out.print(i + ", ");
                // }
                // System.out.print("]");
                // }
                // System.out.println("]");

                if (prevStates.contains(cur.id)) {
                    continue;
                }

                prevStates.add(cur.id);

                if (cur.moves.size() == 0) {
                    minResult = Math.min(minResult, cur.countPebbles());
                    continue;
                }

                for (Integer[] m : cur.moves) {
                    ArrayList<Integer[]> tempMoves = new ArrayList<>();
                    for (int i = 0; i < cur.moves.size(); i++) {
                        Integer[] tempMove = cur.moves.get(i);
                        tempMoves.add(new Integer[] { tempMove[0], tempMove[1] });
                    }

                    // Make the move
                    String tempS = "";
                    ArrayList<Integer> toRemove = new ArrayList<>();
                    if (cur.s.charAt(m[0]) == 'o') {
                        // Going right
                        if (m[1] + 1 < cur.s.length()) {
                            tempS = cur.s.substring(0, m[0]) + "--o" + cur.s.substring(m[1] + 1, cur.s.length());
                        } else {
                            tempS = cur.s.substring(0, m[0]) + "--o";
                        }

                        // Add new move
                        if (m[1] + 2 < cur.s.length() && cur.s.charAt(m[1] + 1) == 'o') {
                            tempMoves.add(new Integer[] { m[1], m[1] + 2 });
                        }

                        // Remove moves
                        for (int i = 0; i < tempMoves.size(); i++) {
                            if (tempMoves.get(i)[0] == m[0]) {
                                toRemove.add(i);
                            }
                            // 1 move behind
                            if (i - 1 >= 0
                                    && (tempMoves.get(i - 1)[0] == m[0] - 1 || tempMoves.get(i - 1)[0] == m[0] - 2)) {

                            }
                            // 2 moves infront
                            if (i + 1 < tempMoves.size() && tempMoves.get(i + 1)[0] == m[0] + 2) {
                                toRemove.add(i);
                            }
                        }

                    } else {
                        // Going left
                        if (m[1] + 1 < cur.s.length()) {
                            tempS = cur.s.substring(0, m[0]) + "o--" + cur.s.substring(m[1] + 1, cur.s.length());
                        } else {
                            tempS = cur.s.substring(0, m[0]) + "o--";
                        }

                        // Add new move
                        if (m[0] - 2 >= 0 && cur.s.charAt(m[0] - 1) == 'o') {
                            tempMoves.add(new Integer[] { m[0] - 2, m[0] });
                        }

                        // Remove moves

                        for (int i = 0; i < tempMoves.size(); i++) {
                            if (tempMoves.get(i)[0] == m[0] || (i != tempMoves.size() - 1
                                    && (tempMoves.get(i + 1)[0] == m[0] + 1 || tempMoves.get(i + 1)[0] == m[0] + 2))) {
                                toRemove.add(i);
                            }
                            if (i - 1 >= 0 && tempMoves.get(i - 1)[0] == m[0] - 2) {
                                toRemove.add(i);
                            }
                        }
                    }

                    Collections.sort(toRemove, Collections.reverseOrder());
                    for (Integer r : toRemove) {
                        tempMoves.remove((int) r);
                    }

                    State nextState = new State(tempS, tempMoves);
                    queue.add(nextState);
                }
            }
            System.out.println(minResult);
        }
    }

    public static ArrayList<Integer[]> getMoves(String s) {
        ArrayList<Integer[]> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.substring(i, i + 3).equals("oo-") || s.substring(i, i + 3).equals("-oo")) {
                result.add(new Integer[] { i, i + 2 });
            }
        }

        return result;
    }
}
