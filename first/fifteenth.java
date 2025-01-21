package a;

public class fifteenth {
    public static void main(String[] args) {
        int spaces = 10;
        char symbol = '8';
        for(int i = 0 ; i <= 10; i++){
            for(int k = 0; k<spaces;k++) {
                System.out.print(' ');
            }
            for(int j = 0 ; j < i; j++) {
                System.out.print(symbol);
               if(i!=0){
                    System.out.print(' ');
               }
            }
            spaces--;
            System.out.println();
        }
    }
}
