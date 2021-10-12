import java.util.*;

public class Main2 {

    static class State {
        String s;
        ArrayList<Integer[]> moves;
        int id;
        int num;

        public State(String s, ArrayList<Integer[]> moves, int num) {
            this.s = s;
            this.moves = moves;
            this.num = num;
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

        HashMap<Integer, Integer> dp = new HashMap<>();
        while (n-- > 0) {
            String s = sc.next();

            ArrayDeque<State> queue = new ArrayDeque<>();
            ArrayList<Integer> parents = new ArrayList<Integer>();

            State start = new State(s, getMoves(s), 0);
            parents.add(0);
            queue.add(start);

            HashSet<Integer> prevStates = new HashSet<>();

            int minResult = Integer.MAX_VALUE;
            int minIndex = 0;

            HashMap<Integer, Integer> indexToState = new HashMap<Integer, Integer>();

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

                // Check if we have been to this state before
                if (prevStates.contains(cur.id)) {
                    // System.out.println("REPEATED: " + cur.s);
                    continue;
                }

                prevStates.add(cur.id);

                // Record parent of cur iteration
                parents.add(cur.num);
                indexToState.put(parents.size() - 1, cur.id);

                // Check if state has been traversed before calculated before
                if (dp.containsKey(cur.id)) {
                    // minResult = Math.min(minResult, dp.get(cur.id));
                    if (minResult > dp.get(cur.id)) {
                        minResult = dp.get(cur.id);
                        minIndex = parents.size() - 1;
                    }
                    continue;
                }

                if (cur.moves.size() == 0) {
                    minResult = Math.min(minResult, cur.countPebbles());
                    if (minResult > cur.countPebbles()) {
                        minResult = cur.countPebbles();
                        minIndex = parents.size() - 1;
                    }
                    continue;
                }

                // Sub-tree we care about

                for (Integer[] m : cur.moves) {
                    // Make the move
                    String tempS = "";
                    if (cur.s.charAt(m[0]) == 'o') {
                        if (cur.s.length() - 1 != m[1]) {
                            tempS = cur.s.substring(0, m[0]) + "--o" + cur.s.substring(m[1] + 1, cur.s.length());
                        } else {
                            tempS = cur.s.substring(0, m[0]) + "--o";
                        }
                    } else {
                        if (cur.s.length() - 1 != m[1]) {
                            tempS = cur.s.substring(0, m[0]) + "o--" + cur.s.substring(m[1] + 1, cur.s.length());
                        } else {
                            tempS = cur.s.substring(0, m[0]) + "o--";
                        }
                    }

                    State nextState = new State(tempS, getMoves(tempS), parents.size() - 1);
                    queue.add(nextState);
                }
            }
            // Save result for future problems
            int tempParent = minIndex;
            while (tempParent != 0) {
                dp.put(indexToState.get(tempParent), minResult);
                tempParent = parents.get(tempParent);
            }
            // System.out.println(dp);
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