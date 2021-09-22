public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        while (n != 0 && m != 0) {
            int[][] grid = new int[n][n];

            // 0 -> Empty
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = 0;
                }
            }

            // 1 -> Hole
            for (int i = 0; i < n; i++) {
                grid[sc.nextInt()][sc.nextInt()] = 1;
            }

            int solutions = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // For every starting position i,j

                }
            }

            n = sc.nextInt();
            m = sc.nextInt();
        }

    }

}
