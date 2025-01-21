package b.assignment1.first;
import java.util.Scanner;
public class as1sixth
{
    public static int[] array;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = -1;
        int temp_ = 0 ;
        array = new int[n];
        for(int i = 0 ; i < n ; i++){
            temp_ = scanner.nextInt();
            if(max < temp_){
                max = temp_;
            }
            array[i] = temp_;
        }
        System.out.println(max);
    }
}
