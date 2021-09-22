import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] candidates = new int[n];
            int total = 0;
            for(int j = 0; j < n; j++) {
                candidates[j] = sc.nextInt(); 
                total += candidates[j];
            }
            int best = 0;
            boolean secondBest = false;
            for(int j = 1; j < candidates.length; j++) {
                if(candidates[best] < candidates[j]) {
                    best = j;
                    secondBest = false;
                } else if(candidates[best] == candidates[j]) {
                    secondBest = true;
                }
            }
            if(secondBest) {
                System.out.println("no winner");
            } else if(candidates[best] > total/2) {
                System.out.println("majority winner " + (best+1));
            } else {
                System.out.println("minority winner " + (best+1));
            }
        }
    }
}
