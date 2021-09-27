import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String answer = sc.next();
        
        StringBuilder adrian = new StringBuilder();
        StringBuilder bruno = new StringBuilder();
        StringBuilder goran = new StringBuilder();

        int adrianCount = 0;
        int brunoCount = 0;
        int goranCount = 0;
        for(int i = 0; i < answer.length(); i++) {
            if(i == 0) {
                adrian.append("A");
                bruno.append("B");
                goran.append("C");
            } else if (i == 1) {
                adrian.append("B");
                bruno.append("A");
                goran.append("C");
                
            } else {
                char adrianAppend = (char)(adrian.charAt(adrian.length() - 1) + 1);
                if(adrianAppend == 'D') {
                    adrianAppend = 'A';
                }
                adrian.append(adrianAppend);

                if(bruno.charAt(bruno.length() - 1) != 'B') {
                    bruno.append('B');
                } else {
                    if(bruno.charAt(bruno.length() - 2) == 'A') {
                        bruno.append('C');
                    } else {
                        bruno.append('A');
                    }
                }

                if(goran.charAt(goran.length() - 1) != goran.charAt(goran.length() - 2)) {
                    goran.append(goran.charAt(goran.length() - 1));
                } else {
                    char goranAppend = (char)(goran.charAt(goran.length() - 1) + 1);
                    if(goranAppend == 'D') {
                        goranAppend = 'A';
                    }
                    goran.append(goranAppend);
                }
            }

            if(adrian.charAt(adrian.length() - 1) == answer.charAt(i))  {
                adrianCount++;
            }
            if(bruno.charAt(bruno.length() - 1) == answer.charAt(i))  {
                brunoCount++;
            }
            if(goran.charAt(goran.length() - 1) == answer.charAt(i))  {
                goranCount++;
            }
        }

        int best = Math.max(adrianCount, Math.max(brunoCount, goranCount));
        System.out.println(best);
        if(best == adrianCount) {
            System.out.println("Adrian");
        }
        if(best == brunoCount) {
            System.out.println("Bruno");
        }
        if(best == goranCount) {
            System.out.println("Goran");
        }
    }
}

