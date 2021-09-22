import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> answers = new HashSet<>();
        
        while(sc.hasNext()) {
            int cur = sc.nextInt();
            answers.add(cur % 42);
        }

        System.out.println(answers.size());
    }
}
