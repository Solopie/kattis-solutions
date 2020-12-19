import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int wallHeight = sc.nextInt();
        int wallWidth = sc.nextInt();
        int numBricks = sc.nextInt();

        int curHeight = 0;
        int curWidth = 0;

        // Simulate placing each brick
        for (int i = 0; i < numBricks; i++) {
            curWidth += sc.nextInt();

            // Check if brick doesn't fit width
            if (curWidth > wallWidth) {
                System.out.println("NO");
                System.exit(0);
            } else if (curWidth == wallWidth) {
                // Go to next layer and reset width to 0
                curHeight++;
                curWidth = 0;
            }
        }

        // Wall is able to be completed
        System.out.println("YES");
    }
}