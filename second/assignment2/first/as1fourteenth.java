package b.assignment1.first;
import java.util.Scanner;
public class as1fourteenth{
    public static int[][] array = new int[3][3];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int threshold_row = 0;
        int threshold_col = 0;
        int[] col_sum= new int[3];
        int[] row_sum = new int[3];
        for(int i = 0; i<array.length; i++){
            for(int k = 0 ; k < array[i].length; k++){
                array[i][k] = scanner.nextInt();
                row_sum[threshold_row] +=array[i][k];
                col_sum[threshold_col] +=array[i][k];
                threshold_col++;
            }
            threshold_row++;
            threshold_col=0;

        }
        int max_ = -9129392;
        for(int i = 0; i<col_sum.length; i++){
            if(col_sum[i] > max_){
                max_ = col_sum[i];
            }
            if(row_sum[i] > max_){
                max_ =row_sum[i];
            }
        }
        System.out.println(max_);
    }
}
