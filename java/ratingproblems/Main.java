import java.util.*;

class Main { 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double n = (double)sc.nextInt();
        double k = (double)sc.nextInt();
        
        double total = 0;
        for(int i = 0; i < k; i++) {
            total += (double)sc.nextInt();
        }

        double min = (total + ((-3)*(n-k))) / n;
        double max = (total + ((3)*(n-k))) / n;
        
        System.out.println(min + " " + max);
    }
}
