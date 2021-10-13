import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String result = "valid";
        int[][] moves = new int[][]{{2,-1}, {2, 1}, {-2,-1},{-2,1}, {1,2},{-1,2},{1,-2},{-1,-2}};

        char[][] grid = new char[5][5];
        int count = 0;
        for(int i = 0; i < 5; i++) {
            String line = sc.next();
            for(int j = 0; j < 5; j++) {
                grid[i][j] = line.charAt(j);
                if(grid[i][j] == 'k') {
                    count++;
                }
            }
        }

        if(count != 9) {
            System.out.println("invalid");
            return;
        }
        
        loop:
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 'k') {
                    for(int k = 0; k < moves.length; k++) {
                        int newR = i + moves[k][0];
                        int newC = j + moves[k][1];

                        if(newR >= 0 && newR < 5 && newC >= 0 && newC < 5) {
                            if(grid[newR][newC] == 'k') {
                                result = "invalid";
                                break loop;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
