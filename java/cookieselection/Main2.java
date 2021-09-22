import java.util.*;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        LinkedList<Long> front = new LinkedList<Long>();
        LinkedList<Long> back = new LinkedList<Long>();

        while (sc.hasNext()) {
            String in = sc.next();
            if (in.equals("#")) {
                // Pop out middle element
                if (front.size() <= back.size()) {
                    result.append(back.removeFirst() + "\n");
                } else {
                    result.append(front.removeLast() + "\n");
                }
            } else {
                // Insert number into a list
                long curNum = Long.parseLong(in);
                // We add to back if we have an empty list
                if (front.size() > 0 && curNum < front.get(front.size() - 1)) {
                    // Add to front
                    int indexBack = 0;
                    Iterator<Long> iter = front.descendingIterator();
                    while (iter.hasNext()) {
                        long curElement = iter.next();
                        if (curElement <= curNum) {
                            // Add to current position
                            break;
                        } else {
                            indexBack++;
                        }
                    }

                    // Want to be the element after the index we're at so we plus an index
                    front.add((front.size() - 1) - indexBack + 1, curNum);

                } else {
                    Iterator<Long> iter = back.iterator();
                    int index = 0;
                    while (iter.hasNext()) {
                        long curElement = iter.next();
                        if (curElement >= curNum) {
                            break;
                        } else {
                            index++;
                        }
                    }

                    back.add(index, curNum);
                }

                long listDiff = front.size() - back.size();

                // Rearrange list to even out
                if (listDiff < -1) {
                    // When back is too big
                    front.add(back.removeFirst());
                } else if (listDiff > 1) {
                    // When front is too big
                    back.addFirst(front.removeLast());
                }
            }
        }
        System.out.print(result);
    }
}
