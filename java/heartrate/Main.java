import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        
        for(int i = 0; i < cases; i++) {
            int b = sc.nextInt();
            float s = sc.nextFloat();
            
            float minABPM = (b-1)/s * 60;
            float bpm = b/s * 60;
            float maxABPM = (b+1)/s * 60;
            System.out.printf("%.4f %.4f %.4f\n", minABPM, bpm,maxABPM);
        }
    }
}

