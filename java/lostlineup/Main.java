import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            nums[i] = sc.nextInt();
        }

        int[] results = new int[n];
        results[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            results[nums[i] + 1] = i + 2;
        }

        for (int i = 0; i < results.length - 1; i++) {
            System.out.print(results[i] + " ");
        }

        System.out.println(results[results.length - 1]);
    }
}
