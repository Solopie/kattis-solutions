import java.util.*;
import java.io.*;

public class Main4 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        PriorityQueue<Integer> front = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> back = new PriorityQueue<Integer>();
        StringBuilder sb = new StringBuilder();

        while ((input = reader.readLine()) != null && !input.isEmpty()) {
            if (input.equals("#")) {
                if (front.size() == back.size()) {
                    sb.append(back.poll() + "\n");
                } else {
                    sb.append(front.poll() + "\n");
                    if (front.size() < back.size()) {
                        front.add(back.poll());
                    }
                }
            } else {
                int d = Integer.parseInt(input);
                if (front.isEmpty() || (!back.isEmpty() && d < back.peek())) {
                    front.add(d);
                    if (back.size() + 1 < front.size()) {
                        back.add(front.poll());
                    }
                } else {
                    back.add(d);
                    if (back.size() < front.size()) {
                        front.add(back.poll());
                    }
                }
            }

        }
        System.out.print(sb.toString());
    }
}
