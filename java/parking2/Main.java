import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] positions = new int[n];
            for(int i = 0; i < n; i++) {
                positions[i] = sc.nextInt();
            }

            Arrays.sort(positions);
                
            int total = 0;
            for(int i = 0; i < n-1; i++) {
                total += Math.abs(positions[i] - positions[i+1]);
            }
            
            System.out.println(total*2);
        }
    }
}
