package a;
import java.util.Scanner;
public class eighth {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if(age<20 || age > 60){
            System.out.println("you don't have to work");
        }
    }
}
