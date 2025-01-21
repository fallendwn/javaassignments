package b.assignment1.first;
import java.util.Scanner;
public class as1tenth {
    public static int[][] multiArray;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int temp = 0 ;
        multiArray = new int[n][];
        for(int i = 0 ; i < n ; i++){
            temp = scanner.nextInt();
            multiArray[i] = new int[temp];
        }
    }
}
