import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int r = sc.nextInt();
        
        int[] boats = new int[n + 1];

        for(int i = 0; i < boats.length; i++) {
            boats[i] = 1;
        }

        for(int i = 0; i < s; i++) {
            int curBoat = sc.nextInt();
            boats[curBoat] = 0;
        }

        for(int i = 0; i < r; i++) {
            int curBoat = sc.nextInt();
            boats[curBoat] = 2;
        }

        for(int i = 1; i < boats.length; i++) {
            if(boats[i] == 2) {
                if(i != 1 && boats[i - 1] == 0) {
                    boats[i-1] = 1;
                    boats[i] = 1;
                } else if(i != boats.length - 1 && boats[i + 1] == 0) {
                    boats[i+1] = 1;
                    boats[i] = 1;
                }
            } 
        }

        int sum = 0;
        for(int i = 1; i < boats.length; i++) {
            if(boats[i] == 0) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}
