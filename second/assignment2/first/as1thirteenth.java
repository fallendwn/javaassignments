package b.assignment1.first;
import java.util.Scanner;
public class as1thirteenth {
    public static int[][] array = new int[3][3];
    public static void main(String[] args) {
        int max_int = -2147483648 ;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i<array.length; i++){
            for(int k = 0 ; k<array[i].length;k++){
                array[i][k] = scanner.nextInt();
                if(max_int < array[i][k]){
                    max_int = array[i][k];
                }
            }
        }
        System.out.println(max_int);
    }
}
