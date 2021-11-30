import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int m;
        while ((m = sc.nextInt()) != 0) {
            int curWidth = 0;
            int maxWidth = 0;
            int totalHeight = 0;

            int rowMaxHeight = 0;

            int w = sc.nextInt();
            int h = sc.nextInt();
            while (w != -1 || h != -1) {
                if (curWidth + w >= m + 1) { // Rectangle doesn't fit in row horizontally
                    // Add max height of the row and reset
                    totalHeight += rowMaxHeight;
                    rowMaxHeight = 0;

                    maxWidth = Math.max(maxWidth, curWidth);

                    // Reset row and add the rectangle to new row
                    rowMaxHeight = h;
                    curWidth = w;
                } else {
                    // Add rectangle to row
                    curWidth += w;
                    rowMaxHeight = Math.max(rowMaxHeight, h);
                }

                w = sc.nextInt();
                h = sc.nextInt();
            }

            maxWidth = Math.max(maxWidth, curWidth);
            totalHeight += rowMaxHeight;

            System.out.println(maxWidth + " x " + totalHeight);
        }
    }
}
