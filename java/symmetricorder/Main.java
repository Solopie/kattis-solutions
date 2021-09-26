import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int set = 1;
        while(n != 0) {
            System.out.println("SET " + set);
            int left = 0;
            int right = n-1;
            String[] result = new String[n];
            while(left <= right) {
                if(left == right) {
                    result[left] = sc.next(); 
                } else {
                result[left] = sc.next(); 
                result[right] = sc.next();

                }
                left++;
                right--;
            }

            for(int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }

            set++;
            n = sc.nextInt();
        }
    }
}
