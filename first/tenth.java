package a;
import java.util.Scanner;
public class tenth {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sum = 0 ;
        boolean flag= true;
        while(flag){
            if(scanner.hasNextInt()){
                sum = sum + scanner.nextInt();
            }
            else if(scanner.hasNext("ENTER") ){
                flag = false;
            }
        }
        System.out.println(sum);
    }
}
