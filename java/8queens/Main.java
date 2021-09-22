import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[][] in = new char[8][8];

        for(int i = 0; i < 8; i++) {
            String curLine = sc.nextLine();
            for(int j = 0; j < curLine.length(); j++) {
                in[i][j] = curLine.charAt(j);
            }
        }

        int[][] queens = new int[8][2];
        int qIndex = 0;
        for(int i = 0; i < in.length; i++) {
            for(int j = 0; j < in[i].length; j++) {
                if(in[i][j] == '*') {
                    queens[qIndex++] = new int[]{i,j};

                }
            }
        }
        for(int i = 0; i < queens.length; i++) {
            System.out.println(Arrays.toString(queens[i]));
        }
    }
}
