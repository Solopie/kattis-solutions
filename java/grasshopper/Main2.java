import java.util.*;

public class Main {
    static int[][] temp = new int[][] { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 },
            { -2, -1 } };

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int gr = sc.nextInt();
            int gc = sc.nextInt();
            int lr = sc.nextInt();
            int lc = sc.nextInt();

            HashMap<Integer, HashSet<Integer>> vOrigin = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> vTarget = new HashMap<>();
            Queue<Integer> qOrigin = new LinkedList<Integer>();
            Queue<Integer> qTarget = new LinkedList<Integer>();
            qOrigin.add(gr);
            qOrigin.add(gc);
            qOrigin.add(0);

            vOrigin.put(gr, new HashSet<Integer>());
            vOrigin.get(gr).add(gc);

            qTarget.add(lr);
            qTarget.add(lc);
            qTarget.add(0);

            vTarget.put(lr, new HashSet<Integer>());
            vTarget.get(lr).add(lc);

            boolean found = false;
            queue: while (qOrigin.size() != 0 && qTarget.size() != 0) {
                int curOriginR = qOrigin.poll();
                int curOriginC = qOrigin.poll();
                int levelOrigin = qOrigin.poll();

                int curTargetR = qTarget.poll();
                int curTargetC = qTarget.poll();
                int levelTarget = qTarget.poll();

                for (int i = 0; i < temp.length; i++) {
                    int newOriginR = curOriginR + temp[i][0];
                    int newOriginC = curOriginC + temp[i][1];

                    if (newOriginR <= r && newOriginR >= 1 && newOriginC <= c && newOriginC >= 1) {
                        if (vOrigin.containsKey(newOriginR) && vOrigin.get(newOriginR).contains(newOriginC)) {
                            System.out.println(levelOrigin + levelTarget + 1);
                            found = true;
                            break queue;
                        }
                        // Check visited
                        if (vOrigin.containsKey(newOriginR) && vOrigin.get(newOriginR).contains(newOriginC)) {
                            continue;
                        }

                        // Set visited
                        if (!vOrigin.containsKey(newOriginR)) {
                            vOrigin.put(newOriginR, new HashSet<Integer>());
                        }
                        vOrigin.get(newOriginR).add(newOriginC);

                        qOrigin.add(newOriginR);
                        qOrigin.add(newOriginC);
                        qOrigin.add(levelOrigin + 1);
                    }

                }

                for (int i = 0; i < temp.length; i++) {
                    int newTargetR = curTargetR + temp[i][0];
                    int newTargetC = curTargetC + temp[i][1];

                    if (newTargetR <= r && newTargetR >= 1 && newTargetC <= c && newTargetC >= 1) {
                        if (vTarget.containsKey(newTargetR) && vTarget.get(newTargetR).contains(newTargetC)) {
                            System.out.println(levelOrigin + levelTarget + 1);
                            found = true;
                            break queue;
                        }
                        // Check visited
                        if (vTarget.containsKey(newTargetR) && vTarget.get(newTargetR).contains(newTargetC)) {
                            continue;
                        }

                        // Set visited
                        if (!vTarget.containsKey(newTargetR)) {
                            vTarget.put(newTargetR, new HashSet<Integer>());
                        }
                        vTarget.get(newTargetR).add(newTargetC);

                        qTarget.add(newTargetR);
                        qTarget.add(newTargetC);
                        qTarget.add(levelTarget + 1);
                    }

                }
            }

            if (!found) {
                System.out.println("impossible");
            }
        }
    }
}
