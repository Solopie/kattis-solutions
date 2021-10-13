import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, String> m = new HashMap<>();
        m.put('a',"@");
        m.put('b', "8");
        m.put('c', "(");
        m.put('d', "|)");
        m.put('e', "3");
        m.put('f', "#");
        m.put('g', "6");
        m.put('h', "[-]");
        m.put('i', "|");
        m.put('j', "_|");
        m.put('k', "|<");
        m.put('l',"1");
        m.put('m',"[]\\/[]");
        m.put('n',"[]\\[]");
        m.put('o', "0");
        m.put('p', "|D");
        m.put('q',"(,)");
        m.put('r', "|Z");
        m.put('s', "$");
        m.put('t', "']['");
        m.put('u', "|_|");
        m.put('v', "\\/");
        m.put('w', "\\/\\/");
        m.put('x', "}{");
        m.put('y', "`/");
        m.put('z', "2");

        String line = sc.nextLine().toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < line.length(); i++) {
            if(m.containsKey(line.charAt(i))) {
                sb.append(m.get(line.charAt(i)));
            } else {
                sb.append(line.charAt(i));
            }
        }

        System.out.println(sb);

    }
}
