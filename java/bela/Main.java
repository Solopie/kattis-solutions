import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt()*4;
        char dominant = sc.next().charAt(0);

        HashMap<Character,Integer[]> pointTable = new HashMap<>();

        pointTable.put('A',new Integer[]{11,11});
        pointTable.put('K',new Integer[]{4,4});
        pointTable.put('Q',new Integer[]{3,3});
        pointTable.put('J',new Integer[]{20,2});
        pointTable.put('T',new Integer[]{10,10});
        pointTable.put('9',new Integer[]{14,0});
        pointTable.put('8',new Integer[]{0,0});
        pointTable.put('7',new Integer[]{0,0});
    
        int total = 0;
        for(int i = 0; i < lines; i++) {
            String card = sc.next();
            if(card.charAt(1) == dominant) {
                total += pointTable.get(card.charAt(0))[0];
            } else {
                total += pointTable.get(card.charAt(0))[1];
            }
        }
        System.out.println(total);
    }
}
