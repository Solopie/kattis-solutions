import java.util.*;

public class Main {
    public static class Node {
        int index;
        Node next;
        Node before;

        public Node(int index) {
            this.index = index;
        }

        public void setNext(Node node) {
            this.next = node;
            node.before = this;
        }

        public void setBefore(Node node) {
            this.before = node;
            node.next = this;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public boolean hasBefore() {
            return this.before != null;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int numQueries = sc.nextInt();

        Node[] nodes = new Node[nums];

        for (int i = 0; i < numNodes.length; i++) {
            numNodes[i] = new Node(0);
        }

        for (int i = 0; i < numQueries; i++) {
            String query = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();

            switch (query) {
                case "=":
                    if (!nodes[a].hasNext() && !nodes[b].hasNext()) {
                        // Both are by themselves so we link them together
                        nodes[a].setNext(nodes[b]);
                        nodes[b].setNext(nodes[a]);
                    } else if (!nodes[a].hasNext()) {
                        // Only a is by itself so we have to add it to the b set
                        nodes[b].setNext(nodes[a]);
                    }
            }
        }
    }
}
