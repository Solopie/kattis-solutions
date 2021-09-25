class Test {
    public static void main(String args[]) {
        for(int i = 'A'; i <= 'Z'; i++) {
            if(i >= 'A' && i <= 'A' + 9) {
                System.out.print("0" + (i - 'A') + " ");
            } else {
                System.out.print(i - 'A' + " ");
            }
        }

        System.out.println();
        for(int i = 'A'; i <= 'Z'; i++) {
            System.out.print("0" + (char)i + " ");
        }
                    
                
        
    }
}
