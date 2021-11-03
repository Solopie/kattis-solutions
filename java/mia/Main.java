import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        boolean end = false;
        while (!end) {
            int playerOne = -1;
            boolean playerOneDouble = false;
            if (nums[0] == nums[1]) {
                playerOneDouble = true;
            }
            if (nums[0] > nums[1]) {
                playerOne = Integer.parseInt(String.valueOf(nums[0]) + String.valueOf(nums[1]));
            } else {
                playerOne = Integer.parseInt(String.valueOf(nums[1]) + String.valueOf(nums[0]));
            }

            int playerTwo = -1;
            boolean playerTwoDouble = false;
            if (nums[2] == nums[3]) {
                playerTwoDouble = true;
            }
            if (nums[2] > nums[3]) {
                playerTwo = Integer.parseInt(String.valueOf(nums[2]) + String.valueOf(nums[3]));
            } else {
                playerTwo = Integer.parseInt(String.valueOf(nums[3]) + String.valueOf(nums[2]));
            }

            if (playerOne == playerTwo) {
                sb.append("Tie.\n");
            } else if ((playerOne == 21) || (playerTwo != 21
                    && ((playerOneDouble && !playerTwoDouble) || (!playerTwoDouble && playerOne > playerTwo)
                            || (playerOneDouble && playerTwoDouble && playerOne > playerTwo)))) {
                sb.append("Player 1 wins.\n");
            } else {
                sb.append("Player 2 wins.\n");
            }

            end = true;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
                if (nums[i] != 0) {
                    end = false;
                }
            }
        }

        System.out.print(sb);

    }
}
