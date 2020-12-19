import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int limit = sc.nextInt();
        int lines = sc.nextInt();

        int numPeople = 0;
        int denied = 0;

        for(int i = 0; i < lines; i++) {
            String action = sc.next();
            int value = sc.nextInt();

            switch(action) {
                case "enter":
                    if(numPeople +  value > limit) {
                        denied++;
                    } else {
                        numPeople += value;
                    }
                    break;
                case "leave":
                    numPeople -= value;
                    break;
                }
        }
        System.out.println(denied);
    }
}
