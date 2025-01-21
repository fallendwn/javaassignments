package a;
import java.util.Scanner;
public class fifth {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a>=0){
            System.out.println("It's warm outside");
        }
        else{
            System.out.println("It's cold outside");
        }
    }
}
