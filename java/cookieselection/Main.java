import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> front = new LinkedList<>();
        LinkedList<Integer> back = new LinkedList<>();

        while (sc.hasNext()) {
            String cur = sc.next();
            if (cur.equals("#")) {
                // Pop out middle element
                if (front.size() <= back.size()) {
                    System.out.println(back.removeFirst());
                } else {
                    System.out.println(front.removeLast());
                }
            } else {
                int curNum = Integer.parseInt(cur);

                // Add number in sorted manner
                // Find smaller list
                int listDiff = front.size() - back.size();
                if (listDiff == 1 || listDiff == 0) {
                    int indexBack = 0;
                    Iterator<Integer> iter = front.descendingIterator();
                    while (iter.hasNext()) {
                        int curElement = iter.next();
                        if (curElement <= curNum) {
                            // Add to current position
                            break;
                        } else {
                            indexBack++;
                        }
                    }

                    // Want to be the element after the index we're at so we plus an index
                    front.add((front.size() - 1) - indexBack + 1, curNum);
                } else if (listDiff == -1) {
                    Iterator<Integer> iter = back.iterator();
                    int index = 0;
                    while (iter.hasNext()) {
                        int curElement = iter.next();
                        if (curElement >= curNum) {
                            break;
                        } else {
                            index++;
                        }
                    }

                    back.add(index, curNum);
                }

                // New sizes
                listDiff = front.size() - back.size();

                // Rearrange list to even out
                if (listDiff < -1) {
                    // When back is too big
                    front.add(back.removeFirst());
                } else if (listDiff > 1) {
                    // When front is too big
                    back.addFirst(front.removeLast());
                }

            }

            System.out.println(front);
            System.out.println(back);
        }
    }
}
