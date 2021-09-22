import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] groups = line.split(";");
        
        int count = 0;
        for(int i = 0; i < groups.length; i++) {
            String[] range = groups[i].split("-");
            if(range.length == 1) {
                count++;
            } else {
                count += Integer.parseInt(range[1]) - Integer.parseInt(range[0]) + 1;
            }
        }

        System.out.println(count);
    }
}
