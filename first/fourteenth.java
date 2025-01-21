package a;
import java.util.Scanner;
public class fourteenth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt(), end = scanner.nextInt(), multiple = scanner.nextInt();
        int a= 0;
        for(int i = start ; i < end; i++){
            a+=i;
            if(a%multiple == 0){
                System.out.println(a);
            }
        }
        System.out.println(a);
    }
}
