import java.util.*;

public class Main {
    static long counter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            counter = 0;
            String input = sc.next();
            // method call goes here
            System.out.println(counter);
        }
        sc.close();
    }

    public static int dp(int idx, HashSet<String> before, HashSet<String> curr, String str) {
        if (idx == str.length()) {
            return counter; // return here?
        }

        char c = str.charAt(idx);
        for (String s : before) {
            if (s.length() % 2 == 0) {
                if (s.charAt(s.length() - 1) != c) {
                    counter = (counter + 1) % 1000000007;
                    curr.add(s + c);
                } else {

                }
            } else {

            }
        }
        before = curr;
        return dp(idx + 1, before, curr, str);
    }
}
/*
 * abcdb a yes
 * 
 * b yes ab no
 * 
 * c yes bc yes ac no
 * 
 * d yes ad no bd yes
 * 
 * cd no bcd no b yes ab yes
 */

/*
 * abcdbb abcdbca
 * 
 * a[1] b[2] c[1] d[1]
 * 
 * a a[0]
 * 
 * a
 * 
 * b ab a? no [] [b0]
 * 
 * c bc b? yes [b]
 * 
 * d cd c? no bcd
 * 
 * b [b] recheck b
 * 
 * 
 */