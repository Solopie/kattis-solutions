import java.util.*;

public class Main {
    public class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node l, Node r) {
            this.val = val;
            left = l;
            right = r;
        }
    }

    public class BST {
        Node head;

        public BST(Node h) {
            this.head = h;
        }

        public void add(int val) {
            Node temp = new Node(val, null, null);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

        }
    }
}
