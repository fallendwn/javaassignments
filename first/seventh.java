package a;
import java.util.Scanner;
public class seventh {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double temperature = scanner.nextDouble();

        boolean isHigh =temperature>36.6, isLow =temperature<36.6;
        if(isHigh){
            System.out.println("High");
        }
        else if(isLow){
            System.out.println("Low");
        }
        else if(!isHigh && !isLow){
            System.out.println("everything cool");
        }
    }
}
