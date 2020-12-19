import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> countResults = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i =  1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                countResults.put(i + j, countResults.getOrDefault(i + j, 0) + 1);
            }
        }
        
        ArrayList<Integer> maxResults = new ArrayList<>();

        int max = -1;
        for(Map.Entry<Integer, Integer> sum : countResults.entrySet()) {
            if(max == -1) {
                max = sum.getValue();
            } else {
                max = Math.max(max, sum.getValue());
            }
        }

        for(Map.Entry<Integer,Integer> sum : countResults.entrySet()) {
            if(sum.getValue() == max) {
                maxResults.add(sum.getKey());
            }
        }
        
        for(Integer i : maxResults) {
            System.out.println(i);
        }
    }
}

    
