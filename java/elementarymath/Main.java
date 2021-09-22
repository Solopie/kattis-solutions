import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] num = new int[n][5];

        for (int i = 0; i < n; i++) {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
            num[i][2] = num[i][0] + num[i][1];
            num[i][3] = num[i][0] - num[i][1];
            num[i][4] = num[i][0] * num[i][1];
        }

        // Answer -> [line, operation]
        HashMap<Integer, Integer[]> answers = new HashMap<>();

    }

    // answer -> [i,2/3/4
    public void findUniqueAnswers(HashMap<Integer, Integer[]> answers, int[][] num, int line) {
        if (answers.size() == num.length) {
            return;
        }

        if (answers.containsKey(num[line][2])) {
            if (answers.containsKey(num[line][3])) {
                if (answers.containsKey(num[line][4])) {
                    return;
                }
            }
        }

    }
}

/*
 * 4 1 5 3 3 4 5 -1 -6
 * 
 * 6, -4, 5 6, 0, 9 9, -1, 20 -7, 5, 6
 * 
 * 
 * s -> a -> 6 -> end -> -4 -> 5 -> b -^ 6 (not new node) -> 0 -> 9 -> c
 */
