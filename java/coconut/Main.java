import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();
        
        // Have 3 states for the players:
        // 0 - Full coconut (+1)
        // 1 - Split coconut (+2)
        // 2 - Split but one hand (+1)

        int[] players = new int[n];

        int numPlayers = n;

        int position = 0;
        int numTapped = 0;
        while(numPlayers > 1) {
            numTapped++;
                    
            if(numTapped == s) {
                players[position] += 1;
            } else if(numTapped == s+1) {
                
            }

            


            if(players[position] == 0) {
                position += 2;
            } else {
                position++;
            }
        }

    }
}
