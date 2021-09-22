import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int ops = Integer.parseInt(reader.readLine());
        LinkedList<Integer> front = new LinkedList<Integer>();
        LinkedList<Integer> back = new LinkedList<Integer>();

        String answer = "";

        while (ops-- > 0) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            int opNum = Integer.parseInt(line[1]);

            switch (op) {
                case "push_back":
                    back.add(opNum);
                    if (front.size() < back.size()) {
                        front.add(back.get(0));
                        back.remove(0);
                    }
                    break;
                case "push_front":
                    front.addFirst(opNum);
                    if (front.size() > back.size() + 1) {
                        back.addFirst(front.get(front.size() - 1));
                        front.remove(front.size() - 1);
                    }
                    break;
                case "push_middle":
                    if (front.size() == back.size()) {
                        front.add(opNum);
                    } else {
                        back.addFirst(opNum);
                    }
                    break;
                case "get":
                    if (opNum < front.size()) {
                        answer += front.get(opNum) + "\n";
                    } else {
                        answer += back.get(opNum - front.size()) + "\n";
                    }
                    break;
            }
        }

        System.out.println(answer);
    }
}
