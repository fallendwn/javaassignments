package b.assignment1.first;
import java.util.Scanner;
public class as1fifteenth {
    public static int[][] array = new int[3][3];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int threshold_ = 0;
        for(int i = 0 ; i < 3 ; i ++){
            for(int k = 0 ; k < 3 ; k ++){
                array[i][k] = scanner.nextInt();
            }
        }
        for(int i = 0 ; i < 3 ; i ++){
            for(int k = i ; k < 3 ; k ++){
                threshold_ = array[i][k];
                array[i][k] = array[k][i];
                array[k][i]= threshold_;

            }
            continue;
        }
        for(int i = 0 ;i<3 ; i ++){
            for(int k = 0 ; k < 3 ; k ++){
                System.out.print(array[i][k] + " ");
            }
            System.out.println();
        }

    }

}
