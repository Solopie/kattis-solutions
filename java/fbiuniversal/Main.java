import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Character> map = new HashMap<>();

        map.put('B', '8');
        map.put('G', 'C');
        map.put('I', '1');
        map.put('O', '0');
        map.put('Q', '0');
        map.put('S', '5');
        map.put('U', 'V');
        map.put('Y', 'V');
        map.put('Z', '2');

        String orig = "0123456789ACDEFHJKLMNPRTVWX";

        while (p-- > 0) {
            sb.append(sc.nextInt() + " ");
            String in = sc.next();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < in.length(); i++) {
                char tempChar = in.charAt(i);
                if (map.containsKey(tempChar)) {
                    tempChar = map.get(tempChar);
                    nums.add(orig.indexOf(tempChar));
                } else {
                    nums.add(orig.indexOf(tempChar));
                }
            }
            int check = (2 * nums.get(0) + 4 * nums.get(1) + 5 * nums.get(2) + 7 * nums.get(3) + 8 * nums.get(4)
                    + 10 * nums.get(5) + 11 * nums.get(6) + 13 * nums.get(7)) % 27;

            System.out.println(check);

        }
    }
}
