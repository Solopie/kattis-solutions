import java.util.*;

class Main3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> front = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> back = new PriorityQueue<>();

        while (sc.hasNext()) {
            String in = sc.next();

            if (in.equals("#")) {
                if (front.size() <= back.size()) {
                    System.out.println(back.poll());
                } else {
                    System.out.println(front.poll());
                }
            } else {
                int curNum = Integer.parseInt(in);
                if (back.size() != 0 && curNum >= back.peek()) {
                    back.add(curNum);
                } else {
                    front.add(curNum);
                }
            }

            // Rebalance sizes ensuring back is longer by 1
            int listDiff = front.size() - back.size();
            if (listDiff < -1) {
                front.add(back.poll());
            } else if (listDiff > 1) {
                back.add(front.poll());
            }
        }
    }
}