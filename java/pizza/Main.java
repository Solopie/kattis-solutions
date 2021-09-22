import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt(), y = sc.nextInt();

            int[] cols = new int[x];
            int[] rows = new int[y];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    int d = sc.nextInt();
                    rows[i] += d;
                    cols[j] += d;
                }
            }

            long minCols = Long.MAX_VALUE;
            for (int i = 0; i < x; i++) {
                long sum = 0;
                for (int j = 0; j < x; j++) {
                    sum += cols[j] * Math.abs(j - i);
                }
                minCols = Math.min(sum, minCols);
            }
            long minRows = Long.MAX_VALUE;
            for (int i = 0; i < y; i++) {
                long sum = 0;
                for (int j = 0; j < y; j++) {
                    sum += rows[j] * Math.abs(j - i);
                }
                minRows = Math.min(sum, minRows);
            }

            System.out.println((minRows + minCols) + " blocks");
        }
    }
}

/*
 * 0 8 2 0 | 10 1 4 5 0 | 10 0 1 0 1 | 2 3 9 2 0 | 14 - - - - 4 22 9 1
 * 
 * 10*0 + 10*1 + 2*2 + 14*3 = 56 10*1 + 10*0 + 2*1 + 14*2 = 40 10*2 + 10*1 + 2*0
 * + 14*1 = 44 10*3 + 10*2 + 2*1 + 14*0 = 52
 * 
 * 4*0 + 22*1 + 9*2 + 1*3 = 43 4*1 + 22*0 + 9*1 + 1*2 = 15 4*2 + 22*1 + 9*0 +
 * 1*1 = 31 4*3 + 22*2 + 9*1 + 1*0 = 65
 * 
 * 40+15 = 55
 * 
 */
