import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();

        int[][] arr = new int[c][r];
        int[][] result = new int[c][r];
        boolean[][][] visited = new int[c][r][4];

        sc.nextLine();
        sc.nextLine();
        for (int i = 0; i < c; i++) {
            Arrays.fill(result[0], Integer.MAX_VALUE);
            for (int j = 0; j < r; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();
        int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<Integer> pq = new Queue();

    }

    public static class Pos {
        int x, y, energy, dir;

        public pos(int x,int y,int e, int d){
			this.x=x;
			this.y=y;
			energy=e;
			dir=d;
		}

        public int compareTo(Pos o) {
            return this.energy - o.energy;
        }
    }

}