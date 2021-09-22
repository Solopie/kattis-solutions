import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        
        boolean first = false;
        int low = -1;
        int high = -1;
        for(int i = l; i <= d; i++) {
            if(sumDigits(i) == x) {
                if(!first) {
                    low = i;
                    high = i;
                    first = true;
                } else {
                    high = i;
                }
            }
        }

        System.out.println(low);
        System.out.println(high);
    }

    public static int sumDigits(int n) {
        int sum = 0;

        String a = String.valueOf(n);

        for(int i = 0; i < a.length(); i++) {
            sum += Integer.parseInt(a.substring(i,i+1));
        }

        return sum;
    }
}
